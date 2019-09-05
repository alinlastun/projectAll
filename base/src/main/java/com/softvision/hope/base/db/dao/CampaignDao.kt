package com.softvision.hope.base.db.dao

import androidx.room.*
import com.softvision.hope.base.db.model.Campaign
import com.softvision.hope.base.extensions.CD
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CampaignDao {

    @Query("SELECT * FROM campaign")
    abstract fun getAll(): Flow<List<Campaign>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(entity: Campaign)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    abstract fun update(entity: Campaign)

    @Transaction
    open fun upsert(entities: List<Campaign>) {
        CD("Add campaign into DB")
        for (charity in entities) {
            insert(charity)
            update(charity)
        }
    }
}