package com.anurag.spacexextraaedgetask.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class PayloadWeights(
    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("kg"   ) var kg   : Int?    = null,
    @SerializedName("lb"   ) var lb   : Int?    = null

)
