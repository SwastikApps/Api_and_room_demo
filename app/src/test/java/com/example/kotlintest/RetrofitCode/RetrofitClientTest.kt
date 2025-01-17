package com.example.kotlintest.RetrofitCode

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class RetrofitClientTest {

    @Test
    fun getApiService() {
        val retrofit = RetrofitClient
        val result = retrofit.apiService

        assertEquals(true, result)
    }
}