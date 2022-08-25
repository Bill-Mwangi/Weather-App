package com.bill.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

  @GET("v1/forecast?hourly=temperature_2m,relativehumidity_2m,surface_pressure,pressure_msl,windspeed_10m,weathercode&daily=temperature_2m_max,temperature_2m_min&current_weather=true&timezone=Africa%2FNairobi")
  suspend fun getWeatherData(
    @Query("latitude") latitude: Double,
    @Query("longitude") longitude: Double,
  ): WeatherDto
}