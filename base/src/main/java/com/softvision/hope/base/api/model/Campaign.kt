package com.softvision.hope.base.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Campaign (
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("owner")
    val owner: String,
    @SerialName("type")
    val type: String,
    @SerialName("start_date")
    val startDate:String,
    @SerialName("end_date")
    val endDate:String,
    @SerialName("details")
    val details:String,
    @SerialName("target")
    val target:Int
)