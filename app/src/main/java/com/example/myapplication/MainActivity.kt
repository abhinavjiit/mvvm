package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var viewModel: DataViewModel? = null
    lateinit var hello: TextView
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var recyclerView: RecyclerView
    val mainActivityAdapter: MainActivityAdapter by lazy { MainActivityAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello = findViewById(R.id.hello)
        recyclerView = findViewById(R.id.recyclerView)
        hello.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("change", "change")
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mainActivityAdapter


        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(DataViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel?.getProjectListObservable()?.observe(this, Observer {
            mainActivityAdapter.setListData(it)
            mainActivityAdapter.notifyDataSetChanged()
        })

    }
}
