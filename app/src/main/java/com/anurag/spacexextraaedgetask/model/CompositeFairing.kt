package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class CompositeFairing(

    @SerializedName("height") var height: Height? = Height(),
    @SerializedName("diameter") var diameter: Diameter? = Diameter()
)
