package com.example.wildberriesweekfive

import retrofit2.http.GET

interface ApiRequests {
    @GET("all.json")
    suspend fun getSuperHeroes(): List<SuperHeroJSON>
}