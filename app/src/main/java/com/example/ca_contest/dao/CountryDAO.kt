package com.example.ca_contest.dao

import androidx.room.*

// DAO for the Country
@Dao
abstract class CountryDAO {
    @Query("SELECT * FROM country ORDER BY date ASC")
    abstract fun getListCountry(): List<Country>
    @Insert
    abstract fun insert(vararg country: Country)
    @Update
    abstract fun update(vararg country: Country)
    @Query("DELETE FROM country WHERE countryId = :id")
    abstract fun delete(id: Long)
}