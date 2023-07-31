package com.maximilian.cryptocoins.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data (

  @SerializedName("stats" ) var stats : Stats?           = Stats(),
  @SerializedName("coins" ) var coins : ArrayList<Coins> = arrayListOf()

): Parcelable