package com.example.mvvmweatherexample.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmweatherexample.model.Location

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(list: List<Location>)

    @Query("select * from Location where title like :search")
    fun getLocation(search:String):List<Location>
}