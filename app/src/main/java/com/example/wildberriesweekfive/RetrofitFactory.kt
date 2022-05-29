package com.example.wildberriesweekfive

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    fun new() = Retrofit.Builder()
        .baseUrl("https://akabab.github.io/superhero-api/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequests::class.java)
}