package com.maximilian.cryptocoins.presentation.detailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailedViewModel: ViewModel() {

    private val _sparkData = MutableLiveData<FloatArray>()
    val sparkData: LiveData<FloatArray> = _sparkData

    fun parseSparklineToFloat(sparklineList: ArrayList<String>) {
        viewModelScope.launch(Dispatchers.Default) {
            val sparkFloatArray = sparklineList.map { it.toFloat() }.toFloatArray()
            _sparkData.postValue(sparkFloatArray)
        }
    }
}