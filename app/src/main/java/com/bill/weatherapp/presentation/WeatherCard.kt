package com.bill.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bill.weatherapp.R
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
  state: WeatherState,
  backgroundColor: Color,
  modifier: Modifier = Modifier
) {
  state.weatherInfo?.currentWeatherData?.let { weatherData ->
    Card(
      backgroundColor = backgroundColor,
      shape = RoundedCornerShape(9.dp),
      modifier = modifier.padding(15.dp)
    ) {
      Column(
        modifier = modifier
          .fillMaxWidth()
          .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "Today ${
            weatherData.time.format(
              DateTimeFormatter.ofPattern("HH:mm")
            )
          }",
          modifier = Modifier.align(Alignment.End),
          color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
          painter = painterResource(id = weatherData.weatherType.iconRes),
          contentDescription = weatherData.weatherType.weatherDesc,
          modifier = Modifier.width(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
          text = "${weatherData.temperature}℃",
          fontSize = 50.sp,
          color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
          text = weatherData.weatherType.weatherDesc,
          fontSize = 20.sp,
          color = Color.White
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
          modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
        ) {
          WeatherDataDisplay(
            value = weatherData.seaLevelPressure.roundToInt(),
            unit = "hpa",
            icon = ImageVector.vectorResource(
              id = R.drawable.ic_pressure
            ),
            iconTint = Color.White,
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
          )
          WeatherDataDisplay(
            value = weatherData.humidity.roundToInt(),
            unit = "%",
            icon = ImageVector.vectorResource(
              id = R.drawable.ic_drop
            ),
            iconTint = Color.White,
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
          )
          WeatherDataDisplay(
            value = weatherData.windSpeed.roundToInt(),
            unit = "Km/h",
            icon = ImageVector.vectorResource(
              id = R.drawable.ic_wind
            ),
            iconTint = Color.White,
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
          )
        }
      }
    }
  }
}