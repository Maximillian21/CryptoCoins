package com.maximilian.cryptocoins.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiResponse (

  @SerializedName("status" ) var status : String? = null,
  @SerializedName("data"   ) var data   : Data?   = Data()

): Parcelable