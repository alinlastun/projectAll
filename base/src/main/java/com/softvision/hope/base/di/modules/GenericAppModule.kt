package com.softvision.hope.base.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Generic app module that provides Base dependencies. Extend this in your module to define specific
 * dependencies.
 */
@Module(
    includes = [
        DbModule::class,
        ApiModule::class])
abstract class GenericAppModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}
