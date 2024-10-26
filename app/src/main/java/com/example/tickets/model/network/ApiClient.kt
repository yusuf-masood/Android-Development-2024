package com.example.tickets.model.network

import com.example.tickets.model.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/estharossa/fake-api-demo/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
