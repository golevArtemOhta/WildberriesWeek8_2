package com.example.wildberriesweekfive

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    fun new() = Retrofit.Builder()
        .baseUrl("https://www.superheroapi.com/api.php/3202191630032155/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequests::class.java)
}