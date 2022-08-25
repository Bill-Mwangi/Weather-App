package com.bill.weatherapp.data.repository

import com.bill.weatherapp.data.mappers.toWeatherInfo
import com.bill.weatherapp.data.remote.WeatherApi
import com.bill.weatherapp.domain.repository.WeatherRepository
import com.bill.weatherapp.domain.util.Resource
import com.bill.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
  override suspend fun getWeather(latitude: Double, longitude: Double): Resource<WeatherInfo> {
    return try {
      Resource.Success(data = api.getWeatherData(latitude, longitude).toWeatherInfo())
    } catch (e: Exception) {
      e.printStackTrace()
      Resource.Error(e.message ?: "An unknown error occurred.")
    }
  }
}
