package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.Height
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class HeightConverter {
    private val gson = Gson()
    private val type = object : TypeToken<Height>() {}.type

    @TypeConverter
    fun heightToString(height: Height): String? {
        return gson.toJson(height, type)
    }

    @TypeConverter
    fun stringToHeight(string: String): Height? {
        return gson.fromJson(string, type)
    }
}