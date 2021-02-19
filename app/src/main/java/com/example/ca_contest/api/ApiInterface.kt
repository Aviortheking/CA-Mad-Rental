package com.example.ca_contest.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("rest/v2/all")
    fun getCountries(): Call<List<Country>>

}