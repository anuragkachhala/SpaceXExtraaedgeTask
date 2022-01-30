package com.anurag.spacexextraaedgetask.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anurag.spacexextraaedgetask.data.converters.*
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.data.converters.MassConverter
import com.anurag.spacexextraaedgetask.utlis.Constant

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */


@Database(
    entities = [Rocket::class],
    version = DatabaseMigrations.DB_VERSION
)
@TypeConverters(
    JsonToStringConverter::class,
    PayloadWeightTypeConverter::class,
    DiameterConverter::class,
    FirstStageConverter::class,
    EnginesConverter::class,
    HeightConverter::class,
    LandingLegsConverter::class,
    SecondStageConverter::class,
    MassConverter::class,
)
abstract class SpaceXDatabase : RoomDatabase() {


    abstract fun getRocketDao(): RocketDao

    companion object {
        const val DB_NAME = Constant.DATABASE_NAME

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
