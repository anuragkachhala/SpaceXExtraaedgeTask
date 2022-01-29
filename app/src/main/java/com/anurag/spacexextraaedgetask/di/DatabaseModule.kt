package com.anurag.spacexextraaedgetask.di

import android.app.Application
import com.anurag.spacexextraaedgetask.local.SpaceXDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = SpaceXDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providePostsDao(database: SpaceXDatabase) = database.getRocketDao()

}