package com.softvision.hope.base.repository

import com.softvision.hope.base.db.dao.CampaignDao
import com.softvision.hope.base.domain.mapper.CampaignMapper
import com.softvision.hope.base.domain.model.Campaign
import com.softvision.hope.base.extensions.CD
import com.softvision.hope.base.repository.fetcher.CampaignFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class CampaignRepository @Inject constructor(
    private val campaignFetcher: CampaignFetcher,
    private val campaignDao: CampaignDao
) {
    fun getCampaign(isActiveCampaign: Boolean, scope: CoroutineScope): Flow<List<Campaign>> {
        scope.launch {
            campaignFetcher.fetchCampaign(isActiveCampaign)
          
        }
        return campaignDao.getAll().map { dbCampaign->
            dbCampaign.map { CampaignMapper.map(it) }
        }
    }
}