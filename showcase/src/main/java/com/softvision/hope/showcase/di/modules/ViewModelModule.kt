package com.softvision.hope.showcase.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softvision.hope.base.di.util.ViewModelKey
import com.softvision.hope.base.ui.ViewModelFactory
import com.softvision.hope.showcase.ui.test.TestShowcaseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TestShowcaseViewModel::class)
    internal abstract fun bindTestShowcaseViewModel(
        testShowcaseViewModel: TestShowcaseViewModel) : ViewModel
}
