package com.example.ca_kotlin.dao

import androidx.room.*

// DAO for the Country
@Dao
abstract class VehicleDAO {
    @Query("SELECT * FROM vehicles")
    abstract fun getVehicles(): List<Vehicle>
    @Insert
    abstract fun insert(vararg country: Vehicle)
    @Update
    abstract fun update(vararg country: Vehicle)
    @Query("DELETE FROM vehicles WHERE vehicleId = :id")
    abstract fun delete(id: Long)

    @Query("SELECT * FROM vehicles WHERE vehicleId = :id LIMIT 1")
    abstract fun find(id: Long): Vehicle
}