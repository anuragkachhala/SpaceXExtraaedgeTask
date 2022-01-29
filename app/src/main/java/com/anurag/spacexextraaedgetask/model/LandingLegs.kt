package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class LandingLegs(
    @SerializedName("number"   ) var number   : Int?    = null,
    @SerializedName("material" ) var material : String? = null
)
