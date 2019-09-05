package com.softvision.hope.ui.campaign

import androidx.lifecycle.viewModelScope
import com.softvision.hope.base.ViewModel
import com.softvision.hope.base.extensions.CD
import com.softvision.hope.base.extensions.exhaustive
import com.softvision.hope.base.mvi.MVICoroutineViewModel
import com.softvision.hope.base.repository.CampaignRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CampaignViewModel @Inject constructor(
    private val campaignRepository: CampaignRepository
) : MVICoroutineViewModel<CampaignState, CampaignIntent, CampaignChange>() {


    override suspend fun consume(intent: CampaignIntent): CampaignChange {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var initialState = CampaignState()

    init {
        change(CampaignChange.Initialize)
    }

    override suspend fun mutate(state: CampaignState, change: CampaignChange): CampaignState =
        when (change) {
            CampaignChange.Initialize -> {
                viewModelScope.launch(Dispatchers.ViewModel) {
                    campaignRepository.getCampaign(true, this).collect{
                        CD("Campaign makes updated from DB: ${it.size} campaign")
                    }
                }
                state.copy()
            }
        }.exhaustive
}