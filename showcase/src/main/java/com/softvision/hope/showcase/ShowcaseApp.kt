package com.softvision.hope.showcase

import com.softvision.hope.base.BaseApp
import com.softvision.hope.showcase.di.util.AppInjector

class ShowcaseApp : BaseApp() {
    override fun appInjector() = AppInjector
}