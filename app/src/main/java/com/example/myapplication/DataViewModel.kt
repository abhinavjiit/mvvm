package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


object DataViewModel : ViewModel() {
    private var projectListObservable: LiveData<List<DataModel>>? = null

    init {
        projectListObservable = ApiCallRepo.getUserData()
    }



    fun getProjectListObservable(): LiveData<List<DataModel>>? {
        return projectListObservable
    }

    fun setProjectListObservable(data: List<DataModel>) {
        val mutableLiveData = MutableLiveData<List<DataModel>>()
        mutableLiveData.value = data
        projectListObservable = mutableLiveData

    }

}