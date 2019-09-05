package com.softvision.hope.showcase.ui.test

import com.softvision.hope.base.mvi.Change

sealed class TestShowcaseChange : Change{
    object Initialize : TestShowcaseChange()

    object ButtonClicked : TestShowcaseChange()

    data class StatefulChange(
        val data: String
    ) : TestShowcaseChange()
}