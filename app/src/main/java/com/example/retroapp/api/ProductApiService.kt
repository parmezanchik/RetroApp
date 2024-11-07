package com.example.retroapp.api

import com.example.retroapp.data.ResponseProducts
import com.example.retroapp.data.ResponseSingleProducts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("/products")
    fun getVideos(): Call<ResponseProducts>

    @GET("/products/{id}")
    fun getProductById(@Path("id")id: Int): Call<ResponseSingleProducts>
}