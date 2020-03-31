package com.example.mvvmweatherexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmweatherexample.model.WeatherResponse
import com.example.mvvmweatherexample.repository.DetailsActivityRespository

class DetailsActivityViewModel(application: Application):AndroidViewModel(application) {

    val repository=DetailsActivityRespository(application)
    val showProgress: LiveData<Boolean>
    val response:LiveData<WeatherResponse>
    init {
        this.showProgress=repository.showProgress
        this.response=repository.response
    }

    fun getWeather(woeid:Int){
        repository.getWeather(woeid)
    }
}