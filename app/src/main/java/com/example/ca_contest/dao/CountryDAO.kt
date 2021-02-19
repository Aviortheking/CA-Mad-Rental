package com.example.ca_contest.dao

import androidx.room.*

@Dao
abstract class CountryDAO {
    @Query("SELECT * FROM country")
    abstract fun getListCountry(): List<Country>
    @Insert
    abstract fun insert(vararg country: Country)
    @Update
    abstract fun update(vararg country: Country)
    @Delete
    abstract fun delete(vararg country: Country)
}