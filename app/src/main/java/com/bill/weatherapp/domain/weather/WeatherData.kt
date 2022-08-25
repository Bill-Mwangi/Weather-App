package com.bill.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherData(
  val time: LocalDateTime,
  val temperature: Double,
  val surfacePressure: Double,
  val seaLevelPressure: Double,
  val windSpeed: Double,
  val humidity: Double,
  val weatherType: WeatherType
)