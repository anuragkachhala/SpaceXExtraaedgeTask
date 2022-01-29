package com.anurag.spacexextraaedgetask.repository

import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.utlis.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */


interface SpaceXRocketRepository {
    suspend fun getRockets(): Response<List<Rocket>>
    fun getRocketById(postId: Int): Flow<Rocket>
}