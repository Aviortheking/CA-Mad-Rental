package com.example.ca_kotlin.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

// Model for the country
@Entity(tableName = "vehicles")
class Vehicle(
    @PrimaryKey(autoGenerate = true)
    val vehicleId: Long = 0,
    val name: String? = null,
    val price: String? = null,
    val category: String? = null,
    val image: String? = null
)