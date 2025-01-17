package com.example.kotlintest.RetrofitCode

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/comments")
    suspend fun getData(@Query("page") page: Int): List<Data>
}