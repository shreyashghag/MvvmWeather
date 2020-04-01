package com.example.mvvmweatherexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ConsolidatedWeather(
    @PrimaryKey val id:Long,
    val the_temp:Double
)