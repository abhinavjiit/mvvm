package com.example.myapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/photos")
    fun getData(): Call<List<DataModel>>

}