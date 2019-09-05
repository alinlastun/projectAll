package com.softvision.hope.base.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Campaign(
    @PrimaryKey
    val id: String,
    val name: String,
    val owner: String,
    val type: String,
    val startDate: String,
    val endDate: String,
    val details: String,
    val target: Int
)