package com.softvision.hope.base.di.modules

import com.softvision.hope.base.db.DbCreator
import com.softvision.hope.base.db.HopeDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Database related module. Define DAOs and the DB instance here.
 */
@Module
class DbModule {
    @Singleton
    @Provides
    internal fun provideDb(dbCreator: DbCreator) =
        dbCreator.hopeDb

    @Singleton
    @Provides
    internal fun provideCampaignDao(hopeDb: HopeDb) =
        hopeDb.campaignDao()
}
