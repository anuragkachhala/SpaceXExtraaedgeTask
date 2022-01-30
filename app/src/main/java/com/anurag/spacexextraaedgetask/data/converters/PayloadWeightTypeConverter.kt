package com.anurag.spacexextraaedgetask.data.converters

import androidx.room.TypeConverter
import com.anurag.spacexextraaedgetask.data.model.PayloadWeights
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 30,January,2022
 */

class PayloadWeightTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun payloadWeightToString(PayloadWeights: List<PayloadWeights>): String? {
        return gson.toJson(PayloadWeights)
    }

    @TypeConverter
    fun stringToPayloadWeight(string: String?): List<PayloadWeights> {
        if (string == null) {
            return Collections.emptyList()
        }

        val type = object : TypeToken<List<PayloadWeights>>() {
        }.type

        return gson.fromJson(string, type)
    }

}