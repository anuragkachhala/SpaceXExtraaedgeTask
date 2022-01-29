package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class ThrustVacuum(
    @SerializedName("kN"  ) var kN  : Int? = null,
    @SerializedName("lbf" ) var lbf : Int? = null

)
