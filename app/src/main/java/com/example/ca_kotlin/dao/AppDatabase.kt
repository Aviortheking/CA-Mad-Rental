package com.example.ca_kotlin.dao

import androidx.room.Database
import androidx.room.RoomDatabase

// Database Manager
@Database(entities = [Vehicle::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun vehicleDAO(): VehicleDAO
}