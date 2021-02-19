package com.example.ca_contest.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "country")
class Country(
    @PrimaryKey(autoGenerate = true)
    val countryId: Long = 0,
    val country: String? = null,
    val capitalCity: String? = null,
    val continent: String? = null,
    val code: String? = null,
    val date: Date? = null
)