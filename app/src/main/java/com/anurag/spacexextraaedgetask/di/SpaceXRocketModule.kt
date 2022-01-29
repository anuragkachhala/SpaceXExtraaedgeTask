package com.anurag.spacexextraaedgetask.di

import com.anurag.spacexextraaedgetask.repository.SpaceXRocketRepository
import com.anurag.spacexextraaedgetask.repository.SpaceXRocketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

@ExperimentalCoroutinesApi
@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class SpaceXRocketModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindPostRepository(repository: SpaceXRocketRepositoryImpl): SpaceXRocketRepository
}