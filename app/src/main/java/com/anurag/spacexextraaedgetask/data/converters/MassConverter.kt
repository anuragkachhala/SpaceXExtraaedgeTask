package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.Mass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class MassConverter {
    private val gson = Gson()
    private val type = object : TypeToken<Mass>() {}.type

    @TypeConverter
    fun massToString(mass: Mass): String? {
        return gson.toJson(mass, type)
    }

    @TypeConverter
    fun stringToMass(string: String): Mass? {
        return gson.fromJson(string, type)
    }
}