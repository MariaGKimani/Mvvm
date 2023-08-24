package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Posst
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiService
import com.example.myapplication.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val apiService = ApiService.create()

    val postLiveData = MutableLiveData<List<Posst>>()
    val errLiveData = MutableLiveData<String>()

    // Function to fetch posts
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val fetchedPosts = apiService.getPosts()
                postLiveData.postValue(fetchedPosts)
            } catch (e: Exception) {
                errLiveData.postValue(e.message)
            }
        }
    }
}