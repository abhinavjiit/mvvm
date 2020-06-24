package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_layout_main_activity.view.*

class MainActivityAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listData: List<DataModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_layout_main_activity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listData.isNullOrEmpty()) 0 else listData?.size!!
    }

    fun setListData(listData: List<DataModel>) {
        this.listData = listData
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.textView.text = listData?.get(position)?.title
        }
    }

    class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val textView: TextView = mView.textView
        val imageView: ImageView = mView.imageView
    }
}