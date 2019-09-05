package com.softvision.hope.base.db

import android.content.Context
import androidx.room.Room
import com.softvision.hope.base.Config
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbCreator @Inject constructor(
    context: Context,
    migrations: Migrations) {
    val hopeDb: HopeDb =
            Room
                    .databaseBuilder(context, HopeDb::class.java, Config.DbName)
                    .addMigrations(*migrations.all())
                    .fallbackToDestructiveMigration()
                    .build()
}