package com.bill.weatherapp.presentation

import com.bill.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
  val weatherInfo: WeatherInfo? = null,
  val isLoading: Boolean = false,
  val error: String? = null
)
