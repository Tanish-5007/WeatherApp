package com.example.weatherforecast.data.source.remote

import com.example.weatherforecast.data.models.LocationModel
import com.example.weatherforecast.data.models.NetworkWeather
import com.example.weatherforecast.data.models.NetworkWeatherForecast
import com.example.weatherforecast.data.source.remote.retrofit.WeatherApiClient
import com.example.weatherforecast.data.source.remote.retrofit.WeatherApiService
import com.example.weatherforecast.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class WeatherRemoteDataSourceImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val retrofitClient: WeatherApiService = WeatherApiClient.retrofitService
): WeatherRemoteDataSource {
    override suspend fun getSearchWeather(query: String): Result<NetworkWeather> {
        TODO("Not yet implemented")
    }

    override suspend fun getWeather(locationModel: LocationModel): Result<NetworkWeather> {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>> {
        TODO("Not yet implemented")
    }
}