package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.Diameter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class DiameterConverter {

    private val gson = Gson()
    private val type = object : TypeToken<Diameter>() {}.type

    @TypeConverter
    fun diameterToString(diameter: Diameter): String? {
        return gson.toJson(diameter, type)
    }

    @TypeConverter
    fun stringToDiameter(string: String): Diameter? {
        return gson.fromJson(string, type)
    }
}