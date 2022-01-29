package com.anurag.spacexextraaedgetask.repository

import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.remote.SpaceXApiService
import com.anurag.spacexextraaedgetask.utlis.Constant
import com.anurag.spacexextraaedgetask.utlis.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

class SpaceXRocketRepositoryImpl @Inject constructor(private val spaceXApiService: SpaceXApiService) :
    SpaceXRocketRepository {

    override suspend fun getRockets(): Response<List<Rocket>> {
        val response = spaceXApiService.getRockets()
        return  response
    }

    override suspend fun getRocketById(id: String): Response<Rocket> {
        val response = spaceXApiService.getRocketById(Constant.SPACEX_BASE_API+Constant.END_POINT_ROCKETS+"/"+id)
        return response
    }


}