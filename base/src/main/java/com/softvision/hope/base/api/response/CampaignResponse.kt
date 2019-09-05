package com.softvision.hope.base.api.response

import com.softvision.hope.base.api.model.Campaign
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CampaignResponse (
    var campaignList: List<Campaign> = emptyList()
)

