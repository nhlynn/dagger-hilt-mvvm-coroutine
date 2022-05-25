package com.linnitsolution.dagger_hilt_mvvm_coroutine.repository

import com.linnitsolution.dagger_hilt_mvvm_coroutine.network.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getWeather() = apiService.getWeather()
}