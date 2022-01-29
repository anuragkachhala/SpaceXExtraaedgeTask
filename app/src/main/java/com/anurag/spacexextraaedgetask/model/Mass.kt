package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class Mass(

    @SerializedName("kg" ) var kg : Int? = null,
    @SerializedName("lb" ) var lb : Int? = null
)
