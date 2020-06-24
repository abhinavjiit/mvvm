package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiCallRepo {


    fun getUserData(): LiveData<List<DataModel>> {
        val data: MutableLiveData<List<DataModel>> =
            MutableLiveData<List<DataModel>>()
        val retro = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiService = retro.create(ApiService::class.java)
        val calll = apiService.getData()
        calll.enqueue(object : Callback<List<DataModel>> {
            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                Log.d("TAG_____", t.message.toString())
            }

            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                val res = response.body()
                val listData = ArrayList<DataModel>()
                res?.let {
                    data.value = it
                }

            }

        })
        return data
    }


}