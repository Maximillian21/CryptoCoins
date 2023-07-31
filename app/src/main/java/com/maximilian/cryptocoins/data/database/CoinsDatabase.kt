package com.maximilian.cryptocoins.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maximilian.cryptocoins.data.models.Coins
import com.maximilian.cryptocoins.utils.ArrayListConverter


@Database(
    entities = [Coins::class],
    version = 1
)
@TypeConverters(ArrayListConverter::class)
abstract class CoinsDatabase: RoomDatabase() {

    abstract fun coinsDao(): CoinsDao

    companion object {
        fun createDb(context: Context): CoinsDatabase {
            return Room.databaseBuilder(context, CoinsDatabase::class.java, "coins.db")
                .build()
        }
    }
}