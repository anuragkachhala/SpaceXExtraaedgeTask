package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.LandingLegs
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class LandingLegsConverter {
    private val gson = Gson()
    private val type = object : TypeToken<LandingLegs>() {}.type

    @TypeConverter
    fun landingLegsToString(landingLegs: LandingLegs): String? {
        return gson.toJson(landingLegs, type)
    }

    @TypeConverter
    fun stringToLandingLegs(string: String): LandingLegs? {
        return gson.fromJson(string, type)
    }
}