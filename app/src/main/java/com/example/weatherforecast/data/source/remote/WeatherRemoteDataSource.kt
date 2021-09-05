package com.example.weatherforecast.data.source.remote

import com.example.weatherforecast.data.models.LocationModel
import com.example.weatherforecast.data.models.NetworkWeather
import com.example.weatherforecast.data.models.NetworkWeatherForecast
import com.example.weatherforecast.utils.Result

interface WeatherRemoteDataSource {

    suspend fun getSearchWeather(query: String): Result<NetworkWeather>

    suspend fun getWeather(locationModel: LocationModel): Result<NetworkWeather>

    suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>>

}