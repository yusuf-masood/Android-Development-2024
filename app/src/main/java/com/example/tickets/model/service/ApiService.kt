package com.example.tickets.model.service

//package com.example.tickets.model.network


import com.example.tickets.model.entity.Offer
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("offer_list") // Ensure this matches your API's endpoint
    fun getOfferList(): Call<List<Offer>> // Make sure to match the method name used in the fragment
}

