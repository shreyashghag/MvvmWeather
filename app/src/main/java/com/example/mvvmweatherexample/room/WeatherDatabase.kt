package com.example.mvvmweatherexample.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmweatherexample.model.ConsolidatedWeather
import com.example.mvvmweatherexample.model.Location

@Database(version = 1,entities = [Location::class,ConsolidatedWeather::class])
abstract class WeatherDatabase :RoomDatabase(){
    companion object{
        fun get(application: Application):WeatherDatabase{
            return Room.databaseBuilder(application,WeatherDatabase::class.java,"Weather")
                .build()
        }


    }
    abstract fun getWeatherDoa():WeatherDao
}