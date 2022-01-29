package com.anurag.spacexextraaedgetask.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

data class FirstStage(

    @SerializedName("thrust_sea_level" ) var thrustSeaLevel : ThrustSeaLevel? = ThrustSeaLevel(),
    @SerializedName("thrust_vacuum"    ) var thrustVacuum   : ThrustVacuum?   = ThrustVacuum(),
    @SerializedName("reusable"         ) var reusable       : Boolean?        = null,
    @SerializedName("engines"          ) var engines        : Int?            = null,
    @SerializedName("fuel_amount_tons" ) var fuelAmountTons : Double?         = null,
    @SerializedName("burn_time_sec"    ) var burnTimeSec    : Int?            = null
)
