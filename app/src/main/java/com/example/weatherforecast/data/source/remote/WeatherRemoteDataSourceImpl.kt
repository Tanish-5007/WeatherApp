package com.example.weatherforecast.data.source.remote

import com.example.weatherforecast.BuildConfig
import com.example.weatherforecast.data.models.LocationModel
import com.example.weatherforecast.data.models.NetworkWeather
import com.example.weatherforecast.data.models.NetworkWeatherForecast
import com.example.weatherforecast.data.source.remote.retrofit.WeatherApiClient
import com.example.weatherforecast.data.source.remote.retrofit.WeatherApiService
import com.example.weatherforecast.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class WeatherRemoteDataSourceImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val retrofitClient: WeatherApiService = WeatherApiClient.retrofitService
): WeatherRemoteDataSource {

    override suspend fun getSearchWeather(query: String): Result<NetworkWeather> =
        withContext(ioDispatcher){
            return@withContext try {
                val result = retrofitClient.getSpecificWeather(
                    query, BuildConfig.API_KEY
                )
                if (result.isSuccessful){
                    val networkWeather = result.body()
                    Result.Success(networkWeather)
                }else{
                    Result.Success(null)
                }
            }catch (e: Exception){
                Result.Error(e)
            }
        }


    override suspend fun getWeather(locationModel: LocationModel): Result<NetworkWeather> =
        withContext(ioDispatcher){
            return@withContext try {
                val result = retrofitClient.getCurrentWeather(
                    locationModel.latitude, locationModel.longitude,BuildConfig.API_KEY
                )
                if(result.isSuccessful){
                    val networkWeather = result.body()
                    Result.Success(networkWeather)
                }else{
                    Result.Success(null)
                }
            }catch (exception: Exception){
                Result.Error(exception)
            }
        }

    override suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>> =
        withContext(ioDispatcher){
            return@withContext try {
                val result = retrofitClient.getWeatherForecast(
                    cityId, BuildConfig.API_KEY
                )
                if(result.isSuccessful){
                    val networkWeatherForecast = result.body()?.weathers
                    Result.Success(networkWeatherForecast)
                }else{
                    Result.Success(null)
                }
            }catch (e: Exception){
                Result.Error(e)
            }
        }

}