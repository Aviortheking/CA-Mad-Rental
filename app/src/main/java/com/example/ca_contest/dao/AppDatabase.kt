package com.example.ca_contest.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ca_contest.Country

@Database(entities = [Country::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun countryDAO(): CountryDAO
}