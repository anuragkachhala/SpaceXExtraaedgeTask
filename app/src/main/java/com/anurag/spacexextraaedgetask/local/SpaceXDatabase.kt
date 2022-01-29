
package com.anurag.spacexextraaedgetask.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.anurag.spacexextraaedgetask.model.Rocket

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */


@Database(
    entities = [Rocket::class],
    version = DatabaseMigrations.DB_VERSION
)
abstract class SpaceXDatabase : RoomDatabase() {


    abstract fun getRocketDao(): RocketDao

    companion object {
        const val DB_NAME = "SpaceX_Database"

        @Volatile
        private var INSTANCE: SpaceXDatabase? = null

        fun getInstance(context: Context): SpaceXDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpaceXDatabase::class.java,
                    DB_NAME
                ).addMigrations(*DatabaseMigrations.MIGRATIONS).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
