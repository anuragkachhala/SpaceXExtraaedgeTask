package com.anurag.spacexextraaedgetask.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class Isp(
    @SerializedName("sea_level" ) var seaLevel : Int? = null,
    @SerializedName("vacuum"    ) var vacuum   : Int? = null
)
