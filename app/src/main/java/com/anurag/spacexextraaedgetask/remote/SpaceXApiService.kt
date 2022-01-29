package com.anurag.spacexextraaedgetask.remote

import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.utlis.Constant.Companion.END_POINT_ROCKETS
import retrofit2.Response
import retrofit2.http.GET

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

interface SpaceXApiService {

    /**
     * Api for fetch all rockets list
     */
    @GET(END_POINT_ROCKETS)
    suspend fun getRockets(): Response<List<Rocket>>


}