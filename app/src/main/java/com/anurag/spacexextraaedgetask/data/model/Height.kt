package com.anurag.spacexextraaedgetask.data.model
import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class  Height(
    @SerializedName("meters" ) var meters : Double? = null,
    @SerializedName("feet"   ) var feet   : Double?    = null
)
