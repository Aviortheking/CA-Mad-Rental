package com.example.ca_contest.dao

import com.example.ca_contest.libs.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// Database Manager
@Database(entities = [Country::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun countryDAO(): CountryDAO
}