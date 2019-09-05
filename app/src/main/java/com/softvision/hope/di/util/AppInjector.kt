package com.softvision.hope.di.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.softvision.hope.App
import com.softvision.hope.base.BaseApp
import com.softvision.hope.base.di.util.IAppInjector
import com.softvision.hope.base.di.util.Injectable
import com.softvision.hope.di.components.AppComponent
import com.softvision.hope.di.components.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

/**
 * Main Hope app Android Injector. It initializes the dependency tree and registers and Activity
 * created callback so every Activity is injected (also its Fragments).
 */
object AppInjector : IAppInjector {
    override fun init(app: BaseApp): AppComponent {
        val appComponent = DaggerAppComponent.builder().application(app).build()
        appComponent.inject(app as App)

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle?) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })

        return appComponent
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true)
        }
    }
}