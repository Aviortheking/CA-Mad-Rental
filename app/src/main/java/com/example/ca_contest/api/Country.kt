package com.example.ca_contest.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country(
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("capital")
    val capital: String,

    @Expose
    @SerializedName("region")
    val region: String,
    @Expose
    @SerializedName("alpha2Code")
    val alpha2Code: String
) {}