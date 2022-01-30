package com.anurag.spacexextraaedgetask.repository

import androidx.annotation.MainThread
import com.anurag.spacexextraaedgetask.local.RocketDao
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.remote.SpaceXApiService
import com.anurag.spacexextraaedgetask.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.Response
import javax.inject.Inject


class SpaceXRocketRepositoryImpl @Inject constructor(
    private val rocketDao: RocketDao,
    private val spaceXApiService: SpaceXApiService
) :
    SpaceXRocketRepository {

    /**
     * Fetched the rockets from network and stored it in database. At the end, data from persistence
     * storage is fetched and emitted.
     */
    override fun getRockets(): Flow<Resource<List<Rocket>>> {
        return object : GetRocketRepository<List<Rocket>, List<Rocket>>() {

            override suspend fun saveRemoteDataResult(response: List<Rocket>) =
                rocketDao.replaceAllRockets(response)

            override fun fetchDataFromLocalDatabase(): Flow<List<Rocket>> =
                rocketDao.getAllRockets()


            override suspend fun fetchDataFromRemote(): Response<List<Rocket>> =
                spaceXApiService.getRockets()
        }.asFlow()
    }
    
    @MainThread
    override fun getRocketDetailsById(id: String): Flow<Rocket> =
        rocketDao.getRocketByRocketId(id).distinctUntilChanged()
}