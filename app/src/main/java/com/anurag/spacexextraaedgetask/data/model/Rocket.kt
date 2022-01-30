package com.anurag.spacexextraaedgetask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.anurag.spacexextraaedgetask.data.converters.*
import com.anurag.spacexextraaedgetask.data.converters.MassConverter
import com.google.gson.annotations.SerializedName

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

@Entity(tableName = "rocket_table")
data class Rocket(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ids")
    val ids:Long,
    @TypeConverters(HeightConverter::class)
    @SerializedName("height"           ) var height         : Height?                   = Height(),
    @TypeConverters(DiameterConverter::class)
    @SerializedName("diameter"         ) var diameter       : Diameter?                 = Diameter(),
    @TypeConverters(MassConverter::class)
    @SerializedName("mass"             ) var mass           : Mass?                     = Mass(),
    @TypeConverters(FirstStageConverter::class)
    @SerializedName("first_stage"      ) var firstStage     : FirstStage?               = FirstStage(),
    @TypeConverters(SecondStageConverter::class)
    @SerializedName("second_stage"     ) var secondStage    : SecondStage?              = SecondStage(),
    @TypeConverters(EnginesConverter::class)
    @SerializedName("engines"          ) var engines        : Engines?                  = Engines(),
    @TypeConverters(LandingLegsConverter::class)
    @SerializedName("landing_legs"     ) var landingLegs    : LandingLegs?              = LandingLegs(),
    @TypeConverters(PayloadWeightTypeConverter::class)
    @SerializedName("payload_weights"  ) var payloadWeights : List<PayloadWeights> = arrayListOf(),
    @TypeConverters(JsonToStringConverter::class)
    @SerializedName("flickr_images"    ) var flickrImages   : List<String>         = arrayListOf(),
    @SerializedName("name"             ) var name           : String?                   = null,
    @SerializedName("type"             ) var type           : String?                   = null,
    @SerializedName("active"           ) var active         : Boolean?                  = null,
    @SerializedName("stages"           ) var stages         : Int?                      = null,
    @SerializedName("boosters"         ) var boosters       : Int?                      = null,
    @SerializedName("cost_per_launch"  ) var costPerLaunch  : Int?                      = null,
    @SerializedName("success_rate_pct" ) var successRatePct : Int?                      = null,
    @SerializedName("first_flight"     ) var firstFlight    : String?                   = null,
    @SerializedName("country"          ) var country        : String?                   = null,
    @SerializedName("company"          ) var company        : String?                   = null,
    @SerializedName("wikipedia"        ) var wikipedia      : String?                   = null,
    @SerializedName("description"      ) var description    : String?                   = null,
    @SerializedName("id"               ) var id             : String
)
