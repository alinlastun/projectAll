package com.softvision.hope.base.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.softvision.hope.base.db.dao.CampaignDao
import com.softvision.hope.base.db.model.Campaign

@Database(
    entities = [Campaign::class],
    version = Migrations.DB_VERSION,
    exportSchema = true
)
abstract class HopeDb : RoomDatabase() {
    abstract fun campaignDao(): CampaignDao
}