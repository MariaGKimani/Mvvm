package com.example.myapplication.api

import com.example.myapplication.model.Posst
import retrofit2.http.GET

interface ApiService {
    @GET("/posts") // Fix the endpoint to "/posts"
    suspend fun getPosts(): List<Posst>

    companion object {
        fun create(): ApiService {
            return ApiClient.buildApiClient(ApiService::class.java)
        }
    }
}