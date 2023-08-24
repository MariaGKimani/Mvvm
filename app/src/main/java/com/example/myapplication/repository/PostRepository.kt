package com.example.myapplication.repository

import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.ApiService
import com.example.myapplication.model.Posst

class PostRepository {
    private val apiService = ApiService.create() // Create an instance of ApiService using the ApiService object

    suspend fun getPosts(): List<Posst> {
        return apiService.getPosts()
    }
}