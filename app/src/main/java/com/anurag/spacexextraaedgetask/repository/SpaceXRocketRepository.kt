package com.anurag.spacexextraaedgetask.repository

import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.utlis.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

interface SpaceXRocketRepository {
    fun getRockets(): Flow<Resource<List<Rocket>>>
    fun getRocketDetailsById(id: String): Flow<Rocket>
}