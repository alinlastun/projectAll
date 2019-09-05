package com.softvision.hope.ui.campaign

import com.softvision.hope.base.mvi.Change

sealed class CampaignChange : Change{
    object Initialize : CampaignChange()
}