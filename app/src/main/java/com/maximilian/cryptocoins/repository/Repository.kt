package com.maximilian.cryptocoins.repository

import com.maximilian.cryptocoins.data.database.CoinsDao
import com.maximilian.cryptocoins.data.models.ApiResponse
import com.maximilian.cryptocoins.data.models.Coins
import com.maximilian.cryptocoins.data.network.CoinApiService
import retrofit2.Response

class Repository(
    private val apiService: CoinApiService,
    private val coinsDao: CoinsDao
) {

    suspend fun getAllCoins(): Response<ApiResponse> {
        return apiService.getAllCoins()
    }

    fun getCoinsList() = coinsDao.getCoinsList()

    suspend fun save(coin: Coins) = coinsDao.addCoin(coin)

}