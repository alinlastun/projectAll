package com.softvision.hope.base

import android.app.Activity
import android.app.Application
import com.softvision.hope.base.di.util.IAppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

abstract class BaseApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appInjector().init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    // Each app must provide it's own AppInjector so the Dagger tree is generated correctly
    abstract fun appInjector(): IAppInjector
}