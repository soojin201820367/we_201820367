package com.aa.we201820367

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aa.we201820367.databinding.BtnlistBinding
import com.aa.we201820367.hobbyData
import java.util.*

class DataAdapter(val hobbyArr : ArrayList<hobbyData>, val context : Context) :RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BtnlistBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.chName.text = hobbyArr[position].ch_name
        holder.binding.opUsername.text = hobbyArr[position].ch_info
        holder.binding.hash.text = hobbyArr[position].hash

        holder.onItemClick(position)
    }

    override fun getItemCount(): Int {
        return hobbyArr.size
    }
}

class ViewHolder (val binding : BtnlistBinding) : RecyclerView.ViewHolder(binding.root){

    fun onItemClick(position : Int){
        binding.root.setOnClickListener{

        }
    }

}











