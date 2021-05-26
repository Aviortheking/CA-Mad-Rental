package com.example.ca_kotlin.api

import retrofit2.Call
import retrofit2.http.GET

// functions to get the differents elements
interface ApiInterface {

    @GET("exchange/madrental/get-vehicules.php")
    fun getVehicles(): Call<List<Vehicles>>

}