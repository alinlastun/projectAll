package com.softvision.hope.showcase.ui.test

import com.softvision.hope.base.extensions.exhaustive
import com.softvision.hope.base.mvi.MVICoroutineViewModel
import javax.inject.Inject

class TestShowcaseViewModel @Inject constructor()
    : MVICoroutineViewModel<TestShowcaseState, TestShowcaseIntent, TestShowcaseChange>() {
    override var initialState = TestShowcaseState()
    init {
        // You can also trigger changes from within
        change(TestShowcaseChange.Initialize)
    }

    override suspend fun consume(intent: TestShowcaseIntent): TestShowcaseChange =
        when(intent){
            TestShowcaseIntent.ButtonClickedIntent -> TestShowcaseChange.ButtonClicked
            is TestShowcaseIntent.SomeStatefulIntent -> TestShowcaseChange.StatefulChange(intent.intentData)
        }.exhaustive


    override suspend fun mutate(state: TestShowcaseState,
                                change: TestShowcaseChange) : TestShowcaseState =
        when(change){
            TestShowcaseChange.Initialize -> {
                state.copy(
                    someData = "Initial"
                )
            }
            TestShowcaseChange.ButtonClicked -> {
                state.copy(
                    someData = "Button clicked"
                )
            }
            is TestShowcaseChange.StatefulChange -> {
                state.copy(
                    someData = change.data
                )
            }

        }.exhaustive
}