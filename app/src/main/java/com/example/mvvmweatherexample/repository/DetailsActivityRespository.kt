package com.example.mvvmweatherexample.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mvvmweatherexample.model.Location
import com.example.mvvmweatherexample.model.WeatherResponse
import com.example.mvvmweatherexample.network.BASE_URL
import com.example.mvvmweatherexample.network.WeatherNetwork
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivityRespository(var application: Application) {


    val showProgress= MutableLiveData<Boolean>()

    val response=MutableLiveData<WeatherResponse>()

    fun getWeather(woeid:Int){
        showProgress.value=true
        val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(WeatherNetwork::class.java)

        val call=service.getWeather(woeid)
        call.enqueue(object :Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                showProgress.value=false
                Toast.makeText(application,"Error while getting dsata",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                res: Response<WeatherResponse>
            ) {
                showProgress.value=false
                Log.d("DeatilsRespository ","Response${Gson().toJson(res.body())}")
                response.value=res.body()


            }
        })

    }

}