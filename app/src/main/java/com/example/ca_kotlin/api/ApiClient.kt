package com.example.ca_kotlin.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// API Client
object ApiClient {

    var BASE_URL:String="http://s519716619.onlinehome.fr/"
    val getClient: ApiInterface
        get() {

            // Initialize JSON Builder
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            // Initialize Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            // return the response a a Model
            return retrofit.create(ApiInterface::class.java)

        }

}