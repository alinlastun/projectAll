package com.softvision.hope.base.ui

import androidx.lifecycle.ViewModelProvider

interface HasViewModelFactory {
    var viewModelFactory: ViewModelProvider.Factory
}