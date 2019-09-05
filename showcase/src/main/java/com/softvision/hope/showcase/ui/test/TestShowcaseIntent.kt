package com.softvision.hope.showcase.ui.test

import com.softvision.hope.base.mvi.Intent

sealed class TestShowcaseIntent :Intent {

    object ButtonClickedIntent: TestShowcaseIntent()

    data class SomeStatefulIntent(
        val intentData: String
    ) : TestShowcaseIntent()
}