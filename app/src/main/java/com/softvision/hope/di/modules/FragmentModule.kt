package com.softvision.hope.di.modules

import com.softvision.hope.ui.campaign.CampaignFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Generic Fragment injection module. Bind Injectable fragments here (eg. extend BaseFragment or
 * implement Injectable).
 * If a custom Dagger subcomponent is needed, specify the submodule here.
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeCampaignFragment(): CampaignFragment
}
