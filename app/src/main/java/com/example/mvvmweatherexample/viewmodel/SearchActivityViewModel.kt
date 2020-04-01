package com.example.mvvmweatherexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmweatherexample.model.Location
import com.example.mvvmweatherexample.repository.SearchActivityRespository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchActivityViewModel(application: Application) :AndroidViewModel(application) {

    private val repository=SearchActivityRespository(application)
    val showProgress:LiveData<Boolean>

    val locationList:LiveData<List<Location>>

    init {
        this.showProgress=repository.showProgress
        this.locationList=repository.locationList
    }

    fun changeState(){
        repository.changeState()
    }

    fun searchLocation(location:String){
       repository.searchLocation(location)
    }



}