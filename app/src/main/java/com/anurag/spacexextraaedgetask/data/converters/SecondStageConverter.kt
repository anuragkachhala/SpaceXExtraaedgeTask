package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.SecondStage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class SecondStageConverter {
    private val gson = Gson()
    private val type = object : TypeToken<SecondStage>() {}.type

    @TypeConverter
    fun secondStageToString(secondStage: SecondStage): String? {
        return gson.toJson(secondStage, type)
    }

    @TypeConverter
    fun stringToSecondStage(string: String): SecondStage? {
        return gson.fromJson(string, type)
    }
}