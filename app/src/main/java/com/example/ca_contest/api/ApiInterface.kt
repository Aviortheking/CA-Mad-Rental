package com.example.ca_contest.api

import retrofit2.Call
import retrofit2.http.GET

// functions to get the differents elements
interface ApiInterface {

    @GET("rest/v2/all")
    fun getCountries(): Call<List<Country>>

}