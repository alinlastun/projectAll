package com.softvision.hope.base.domain.model

data class Campaign(
    val id: String,
    val name: String,
    val owner: String,
    val type: String,
    val startDate: String,
    val endDate: String,
    val details: String,
    val target: Int
)