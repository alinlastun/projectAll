package com.softvision.hope.showcase.di.modules

import com.softvision.hope.base.di.modules.GenericAppModule
import dagger.Module

@Module(includes = [ViewModelModule::class])
abstract class AppModule : GenericAppModule() {
}
