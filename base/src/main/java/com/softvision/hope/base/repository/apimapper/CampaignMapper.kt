package com.softvision.hope.base.repository.apimapper

import com.softvision.hope.base.api.model.Campaign

object CampaignMapper {
    fun map(campaign: Campaign) =
        com.softvision.hope.base.db.model.Campaign(
        campaign.id,
        campaign.name,
        campaign.owner,
        campaign.type,
        campaign.startDate,
        campaign.endDate,
        campaign.details,
        campaign.target
    )
}