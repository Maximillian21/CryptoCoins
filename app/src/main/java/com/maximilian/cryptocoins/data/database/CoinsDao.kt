package com.maximilian.cryptocoins.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.maximilian.cryptocoins.data.models.Coins

@Dao
interface CoinsDao {

    @Query("SELECT * FROM Coins")
    fun getCoinsList(): List<Coins>

    @Insert
    suspend fun addCoin(coin: Coins)

}