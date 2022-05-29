package com.example.wildberriesweekfive

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequests {
    @GET("all.json")
    suspend fun getSuperHeroes(): List<SuperHeroJSON>
}