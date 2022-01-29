package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class Diameter(
    @SerializedName("meters" ) var meters : Double? = null,
    @SerializedName("feet"   ) var feet   : Double? = null

)
