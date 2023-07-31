package com.maximilian.cryptocoins.di

import com.maximilian.cryptocoins.data.database.CoinsDao
import com.maximilian.cryptocoins.data.network.CoinApiService
import com.maximilian.cryptocoins.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: CoinApiService,
        coinsDao: CoinsDao
    ): Repository {
        return Repository(apiService, coinsDao)
    }

}