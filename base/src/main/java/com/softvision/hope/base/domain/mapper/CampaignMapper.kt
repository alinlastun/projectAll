package com.softvision.hope.base.domain.mapper

import com.softvision.hope.base.db.model.Campaign


object CampaignMapper {
    fun map(campaign: Campaign) =
        com.softvision.hope.base.domain.model.Campaign(
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