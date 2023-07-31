package com.maximilian.cryptocoins.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximilian.cryptocoins.data.models.Coins
import com.maximilian.cryptocoins.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _coinsLiveData = MutableLiveData<List<Coins>>()
    val coinsLiveData: LiveData<List<Coins>> = _coinsLiveData

    fun fetchCoinsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllCoins()

            if (response.isSuccessful) {
                _coinsLiveData.postValue(response.body()?.data?.coins)
                response.body()?.data?.coins?.forEach {
                    Log.d("MainViewModel", "item saved")
                    repository.save(it)
                }
            }
            else {
                Log.d("MainViewModel", response.message())
            }
        }
    }

    fun fetchCoinsListFromDb() {
        viewModelScope.launch(Dispatchers.IO) {
            val localData = repository.getCoinsList()
            if(localData.isNotEmpty()) {
                Log.d("MainViewModel", "loaded from DB")

                _coinsLiveData.postValue(localData)
            }
            else {
                Log.d("MainViewModel", "loaded from internet")
                fetchCoinsList()
            }
        }
    }
}