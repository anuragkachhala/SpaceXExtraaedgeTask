package com.anurag.spacexextraaedgetask.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.utlis.Constant
import kotlinx.coroutines.flow.Flow

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

@Dao
interface RocketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRocket(rocket: List<Rocket>)

    @Transaction
    suspend fun replaceAllRockets(rocket: List<Rocket>) {
        deleteAllRockets()
        insertAllRocket(rocket)
    }

    @Query("DELETE FROM ${Constant.TABLE_NAME}")
    suspend fun deleteAllRockets()

    @Query("SELECT * FROM ${Constant.TABLE_NAME}")
    fun getAllRockets(): LiveData<List<Rocket>>


    @Query("SELECT * FROM ${Constant.TABLE_NAME} where id=:id")
    fun getRocketByRocketId(id: String): LiveData<Rocket>

    @Query("SELECT COUNT(id) FROM ${Constant.TABLE_NAME}")
    fun getSize(): Int

}