package com.anurag.spacexextraaedgetask.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.anurag.spacexextraaedgetask.utlis.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

@ExperimentalCoroutinesApi
abstract class GetRocketRepository<RESULT, REQUEST> {

    fun asFlow() = flow {

        emit(Resource.Success(fetchDataFromLocalDatabase().first()))
        val apiResponse = fetchDataFromRemote()
        val rocketResponse = apiResponse.body()
        if (apiResponse.isSuccessful && rocketResponse != null) {
            saveRemoteDataResult(rocketResponse)
        } else {
            emit(Resource.Failed(apiResponse.message()))
        }
        emitAll(
            fetchDataFromLocalDatabase().map {
                Resource.Success(it)
            }
        )
    }.catch { e ->
        e.printStackTrace()
        emit(Resource.Failed("Network error! Can't get rockets."))
    }
    
    @WorkerThread
    protected abstract suspend fun saveRemoteDataResult(response: REQUEST)

    @MainThread
    protected abstract fun fetchDataFromLocalDatabase(): Flow<RESULT>

    @MainThread
    protected abstract suspend fun fetchDataFromRemote(): Response<REQUEST>
}
