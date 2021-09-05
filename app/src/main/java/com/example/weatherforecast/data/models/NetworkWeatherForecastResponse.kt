package com.example.weatherforecast.data.models

import com.google.gson.annotations.SerializedName

data class NetworkWeatherForecastResponse(

    @SerializedName("list")
    val weathers: List<NetworkWeatherForecast>,

    val city: City
)