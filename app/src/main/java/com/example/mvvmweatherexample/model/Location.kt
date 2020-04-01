package com.example.mvvmweatherexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Location(
    var latt_long:String,
    var location_type:String,
    var title:String,
    @PrimaryKey var woeid:Int

)