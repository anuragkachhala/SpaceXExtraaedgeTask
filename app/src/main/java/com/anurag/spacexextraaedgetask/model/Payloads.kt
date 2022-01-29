package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data  class Payloads (
    @SerializedName("composite_fairing" ) var compositeFairing : CompositeFairing? = CompositeFairing(),
    @SerializedName("option_1"          ) var option1          : String?           = null
)