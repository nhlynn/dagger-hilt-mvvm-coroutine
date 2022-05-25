package com.linnitsolution.dagger_hilt_mvvm_coroutine.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linnitsolution.dagger_hilt_mvvm_coroutine.model.Weather
import com.linnitsolution.dagger_hilt_mvvm_coroutine.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository) : ViewModel() {

    private val _response = MutableLiveData<Weather>()
    val weatherResponse: LiveData<Weather>
        get() = _response

    init {
        getWeather()
    }

    private fun getWeather() =
        viewModelScope.launch {
            try {
                repository.getWeather().let { response ->

                    if (response.isSuccessful) {
                        _response.postValue(response.body())
                    } else {
                        Log.d("tag", "getWeather Error: ${response.code()}")
                    }
                }
            } catch (e: Exception) {
                Log.d("tag", "getWeather Error: ${e.message}")
            }
        }


}