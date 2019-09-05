package com.softvision.hope.di.components

import android.app.Application
import com.softvision.hope.App
import com.softvision.hope.base.di.components.IAppComponent
import com.softvision.hope.di.modules.ActivityModule
import com.softvision.hope.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class])
interface AppComponent : IAppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
