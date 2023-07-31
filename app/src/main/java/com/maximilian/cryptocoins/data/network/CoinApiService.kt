package com.maximilian.cryptocoins.data.network

import com.maximilian.cryptocoins.data.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CoinApiService {

    @GET("coins")
    suspend fun getAllCoins(
        @Header("x-access-token") key: String = "coinrankinga26b947ccb0351e270a960fe993b667c8f39e9213f633851"
    ): Response<ApiResponse>

}