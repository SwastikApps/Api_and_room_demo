package com.example.kotlintest.RetrofitCode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataRepository() {

    private val apiService = RetrofitClient.apiService

    suspend fun getPosts(page: Int): List<Data> {
        return apiService.getData(page)
    }

}