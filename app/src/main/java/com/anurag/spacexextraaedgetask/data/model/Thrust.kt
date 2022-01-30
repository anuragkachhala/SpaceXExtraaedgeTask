package com.anurag.spacexextraaedgetask.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class Thrust(

    @SerializedName("kN"  ) var kN  : Int? = null,
    @SerializedName("lbf" ) var lbf : Int? = null

)
