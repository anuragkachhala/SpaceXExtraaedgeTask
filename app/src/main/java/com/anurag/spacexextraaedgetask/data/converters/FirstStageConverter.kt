package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.FirstStage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class FirstStageConverter {
    private val gson = Gson()
    private val type = object : TypeToken<FirstStage>() {}.type

    @TypeConverter
    fun firstStageToString(firstStage: FirstStage): String? {
        return gson.toJson(firstStage, type)
    }

    @TypeConverter
    fun stringToFirstStage(string: String): FirstStage? {
        return gson.fromJson(string, type)
    }
}