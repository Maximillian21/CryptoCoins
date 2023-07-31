package com.maximilian.cryptocoins.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats (

  @SerializedName("total"          ) var total          : Int?    = null,
  @SerializedName("totalCoins"     ) var totalCoins     : Int?    = null,
  @SerializedName("totalMarkets"   ) var totalMarkets   : Int?    = null,
  @SerializedName("totalExchanges" ) var totalExchanges : Int?    = null,
  @SerializedName("totalMarketCap" ) var totalMarketCap : String? = null,
  @SerializedName("total24hVolume" ) var total24hVolume : String? = null

): Parcelable