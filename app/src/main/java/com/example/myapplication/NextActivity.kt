package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class NextActivity : AppCompatActivity() {
    private var projectListObservablee = MutableLiveData<List<DataModel>>()
    var viewModel: DataViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(DataViewModel::class.java)
        val list = ArrayList<DataModel>()
        val dataMOdel = DataModel()
        dataMOdel.title = "Abhinav"
        list.add(dataMOdel)

        viewModel?.getProjectListObservable()?.observe(this, Observer {
            Toast.makeText(this, "changed", Toast.LENGTH_LONG).show()
        })
        viewModel?.setProjectListObservable(list)
    }
}