package com.softvision.hope.base.mvi

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.softvision.hope.base.ViewModel
import com.softvision.hope.base.extensions.CD
import com.softvision.hope.base.ui.HasViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.reflect.KClass

/**
 * Base class for a ViewModel that implements the MVI pattern and uses Coroutines and Flow.
 */
abstract class MVICoroutineViewModel<S : State, I : Intent, C : Change> : ViewModel(),
    IntentConsumer<I, C>, StateProducer<S> {
    /**
     * Use the ViewModel coroutine scope so all active coroutines are cancelled when destroyed
     * but use a background thread to process changes in state
     */
    private val coroutineContext = viewModelScope.coroutineContext + Dispatchers.ViewModel

    /**
     * Each subclass must specify the initial state of the screen
     */
    protected abstract var initialState: S

    /**
     * Channel used to buffer emitted changes
     */
    private val changes = BroadcastChannel<C>(1)

    /**
     * Store the coroutine that collects the Intent Flow so we can cancel it when another attaches.
     * We only support one IntentDispatcher at the moment.
     */
    private var intentsJob: Job? = null

    /**
     * The state that the StateConsumer observes when attaching to this ViewModel.
     */
    override val state: LiveData<S> = liveData(coroutineContext) {
        changes.openSubscription().consumeAsFlow().scan(initialState) { accumulator, value ->
            mutate(accumulator, value).also { newState ->
                initialState = newState
            }
        }.distinctUntilChanged().collect {
            emit(it)
        }
    }

    /**
     * Function called when the View wants to attach to this ViewModel
     */
    fun attachIntentProducer(producer: IntentProducer<I>) {
        intentsJob?.cancel()
        intentsJob = viewModelScope.launch(Dispatchers.Main) {
            producer.intents.collect {
                changes.send(consume(it))
            }
        }
    }

    /**
     * Called from the ViewModel to trigger a change in the State
     */
    protected fun change(change: C) {
        viewModelScope.launch {
            changes.send(change)
        }
    }

    /**
     * Implement this method to specify how a Change alters the State
     */
    protected abstract suspend fun mutate(state: S, change: C): S
}

/**
 * Extension used for Fragments attaching to ViewModels that use this MVI pattern.
 */
fun <T : MVICoroutineViewModel<S, I, C>, S : State, I : Intent, C : Change, V> V.initViewModel(
    viewModelClass: KClass<T>,
    shared: Boolean = false)
        where V : IntentProducer<I>, V : StateConsumer<S>, V : Fragment, V : HasViewModelFactory {
    val provider = if (shared) {
        ViewModelProviders.of(requireActivity(), viewModelFactory)
    } else {
        ViewModelProviders.of(this, viewModelFactory)
    }
    provider.get(viewModelClass.java).let { viewModel ->
        viewModel.attachIntentProducer(this)
        viewModel.state.observe(viewLifecycleOwner) { state ->
            consume(state)
        }
    }
}