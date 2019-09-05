package com.softvision.hope.base.repository.fetcher

import com.softvision.hope.base.api.CampaignService
import com.softvision.hope.base.db.dao.CampaignDao
import com.softvision.hope.base.extensions.CD
import com.softvision.hope.base.repository.apimapper.CampaignMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.io.IOException
import timber.log.Timber
import javax.inject.Inject

class CampaignFetcher @Inject constructor(
    private val campaignService: CampaignService,
    private val campaignDao: CampaignDao) {

    suspend fun fetchCampaign(isActiveCampaign: Boolean) {
        CD("Start fetching campaign from network ")
        withContext(Dispatchers.IO) {
            try {
                val response = campaignService.getActiveCampaign(isActiveCampaign)
                if (response.isSuccessful) {
                    CD("Success fetching campaign from network")
                    campaignDao.upsert(response.body()?.map { CampaignMapper.map(it) } ?: emptyList())
                    CD("Finished to add into DB")
                } else {
                    CD("Error fetching campaign from network : ${response.errorBody()}")
                    response.errorBody()
                }
            } catch (exception: IOException) {
                Timber.e(exception)
            }
            CD("Finished fetch campaign from network ")
        }
    }
}