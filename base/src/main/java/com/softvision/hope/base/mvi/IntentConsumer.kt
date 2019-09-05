package com.softvision.hope.base.mvi

/**
 * MVI IntentConsumer should be able to accept Intents from the View. In case of applying in MVVM,
 * the ViewModel is the one that should consume the Intents.
 */
interface IntentConsumer<T : Intent, U : Change> {
    suspend fun consume(intent: T): U
}