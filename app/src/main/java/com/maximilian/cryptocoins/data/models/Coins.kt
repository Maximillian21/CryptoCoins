package com.maximilian.cryptocoins.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Coins (

  @SerializedName("uuid"           ) @PrimaryKey var uuid           : String,
  @SerializedName("symbol"         ) var symbol         : String?           = null,
  @SerializedName("name"           ) var name           : String?           = null,
  @SerializedName("color"          ) var color          : String?           = null,
  @SerializedName("iconUrl"        ) var iconUrl        : String?           = null,
  @SerializedName("marketCap"      ) var marketCap      : String?           = null,
  @SerializedName("price"          ) var price          : String?           = null,
  @SerializedName("listedAt"       ) var listedAt       : Int?              = null,
  @SerializedName("tier"           ) var tier           : Int?              = null,
  @SerializedName("change"         ) var change         : String?           = null,
  @SerializedName("rank"           ) var rank           : Int?              = null,
  @SerializedName("sparkline"      ) var sparkline      : ArrayList<String> = arrayListOf(),
  @SerializedName("lowVolume"      ) var lowVolume      : Boolean?          = null,
  @SerializedName("coinrankingUrl" ) var coinrankingUrl : String?           = null,
  @SerializedName("24hVolume"      ) var dayVolume      : String?           = null,
  @SerializedName("btcPrice"       ) var btcPrice       : String?           = null

): Parcelable