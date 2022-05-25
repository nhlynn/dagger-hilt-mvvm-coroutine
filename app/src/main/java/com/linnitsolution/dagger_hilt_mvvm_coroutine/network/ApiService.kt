package com.linnitsolution.dagger_hilt_mvvm_coroutine.network

import com.linnitsolution.dagger_hilt_mvvm_coroutine.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("weather/Myanmar")
    suspend fun getWeather(): Response<Weather>
}