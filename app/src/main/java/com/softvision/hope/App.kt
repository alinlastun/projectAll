package com.softvision.hope

import com.softvision.hope.base.BaseApp
import com.softvision.hope.di.util.AppInjector

/**
 * Main app specific initialization happens here. We also specify our AppInjector to be used by
 * Android Injector
 */
class App : BaseApp() {
    override fun appInjector() = AppInjector
}