package com.softvision.hope.base.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import javax.inject.Inject

class Migrations @Inject constructor() {
    fun all(): Array<Migration> = arrayOf(
            object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("")
                }
            }
    )

    companion object {
        const val DB_VERSION = 1
    }
}