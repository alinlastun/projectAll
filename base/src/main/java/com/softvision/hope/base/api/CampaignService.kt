package com.softvision.hope.base.api

import com.softvision.hope.base.api.model.Campaign
import com.softvision.hope.base.api.response.CampaignResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CampaignService {
    @GET("/dev/campaigns")
    suspend fun getActiveCampaign(@Query("active")isActive: Boolean): Response<List<Campaign>>
}