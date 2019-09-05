package com.softvision.hope.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softvision.hope.base.di.util.ViewModelKey
import com.softvision.hope.base.ui.ViewModelFactory
import com.softvision.hope.ui.campaign.CampaignViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Module responsible for ViewModel multibinding. Each injectable ViewModel needs to be defined here.
 */
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CampaignViewModel::class)
    internal abstract fun bindCampaignViewModel(campaignViewModel: CampaignViewModel): ViewModel
}
