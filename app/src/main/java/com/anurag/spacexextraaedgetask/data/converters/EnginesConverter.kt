package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.Engines
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class EnginesConverter {
    private val gson = Gson()
    private val type = object : TypeToken<Engines>() {}.type

    @TypeConverter
    fun enginesToString(engines: Engines): String? {
        return gson.toJson(engines, type)
    }

    @TypeConverter
    fun stringToEngines(string: String): Engines? {
        return gson.fromJson(string, type)
    }
}