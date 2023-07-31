package com.maximilian.cryptocoins.di

import android.content.Context
import com.maximilian.cryptocoins.data.database.CoinsDao
import com.maximilian.cryptocoins.data.database.CoinsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CoinsDatabase {
        return CoinsDatabase.createDb(context)
    }

    @Singleton
    @Provides
    fun provideCoinsDao(database: CoinsDatabase): CoinsDao {
        return database.coinsDao()
    }
}