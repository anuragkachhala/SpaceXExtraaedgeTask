package com.anurag.spacexextraaedgetask.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.anurag.spacexextraaedgetask.utlis.Constant

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

object DatabaseMigrations {
    const val DB_VERSION = 2

    val MIGRATIONS: Array<Migration>
        get() = arrayOf(
            migration12()
        )

    private fun migration12(): Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ${Constant.TABLE_NAME} ADD COLUMN body TEXT")
        }
    }
}
