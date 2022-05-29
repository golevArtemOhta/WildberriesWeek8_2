package com.example.wildberriesweekfive

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequests {
    @GET("{id}")
    suspend fun getTickets(@Path("id") id: String): SuperHeroJSON
}