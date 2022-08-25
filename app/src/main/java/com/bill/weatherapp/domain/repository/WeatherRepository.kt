package com.bill.weatherapp.domain.repository

import com.bill.weatherapp.domain.util.Resource
import com.bill.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
  suspend fun getWeather(latitude: Double, longitude: Double): Resource<WeatherInfo>
}