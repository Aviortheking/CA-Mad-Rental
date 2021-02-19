package com.example.ca_contest

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity(tableName = "country")
class Country(
    @PrimaryKey(autoGenerate = true)
    val countryId: Long = 0,
    val country: String? = null,
    val capitalCity: String? = null,
    val continent: String? = null,
    val date: SimpleDateFormat? = null)