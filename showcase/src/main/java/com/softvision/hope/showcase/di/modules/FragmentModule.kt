package com.softvision.hope.showcase.di.modules

import com.softvision.hope.showcase.ui.test.TestShowcaseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeTestFragment(): TestShowcaseFragment
}
