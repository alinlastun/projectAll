package com.softvision.hope.showcase.di.modules

import com.softvision.hope.showcase.ui.main.MainShowcaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun contributeMainActivity():MainShowcaseActivity
}
