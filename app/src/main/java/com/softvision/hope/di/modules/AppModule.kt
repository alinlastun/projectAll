package com.softvision.hope.di.modules

import com.softvision.hope.base.di.modules.GenericAppModule
import dagger.Module

/**
 * App dependencies that are specific to the main Hope app should be defined here.
 */
@Module(includes = [ViewModelModule::class])
abstract class AppModule : GenericAppModule()
