package com.linnitsolution.dagger_hilt_mvvm_coroutine.model

data class Weather(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)