package com.example.myapplication

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
        val calll = apiService.getData("1")
        calll.enqueue(object : Callback<DataModel> {
            override fun onFailure(call: Call<DataModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                val res = response.body()
                val listData = ArrayList<DataModel>()
                res?.let {
                    listData.add(it)
                    data.value = listData
                }

            }

        })
        return data
    }


}