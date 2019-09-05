package com.softvision.hope.base.di.util

import com.softvision.hope.base.BaseApp
import com.softvision.hope.base.di.components.IAppComponent

/**
 * App Injector interface.
 * Injecting an app must be done on the specific extending class so Dagger injects it correctly
 */
interface IAppInjector {
    fun init(app: BaseApp): IAppComponent
}