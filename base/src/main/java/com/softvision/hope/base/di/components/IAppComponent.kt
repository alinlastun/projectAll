package com.softvision.hope.base.di.components

/**
 * Base interface for specifying the AppComponent. Useful when needing to create subcomponents for
 * entities that do not use Android Injector (eg. WorkManager) without the submodule knowing
 * about it.
 */
interface IAppComponent