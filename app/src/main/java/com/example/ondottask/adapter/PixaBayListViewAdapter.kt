package com.example.ondottask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ondottask.R
import com.example.ondottask.databinding.ItemGridPixabayBinding
import com.example.ondottask.model.Hit
import com.example.ondottask.viewModel.PixaBayListViewItemModel


class PixaBayListViewAdapter :RecyclerView.Adapter<PixaBayListViewAdapter.ViewHolder>() {

    private lateinit var hitList:List<Hit>


    override fun getItemCount(): Int {
        return if(::hitList.isInitialized) hitList.size else 0
    }

    override fun onBindViewHolder(holder: PixaBayListViewAdapter.ViewHolder, position: Int) {
        holder.bind(hitList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaBayListViewAdapter.ViewHolder {
        val binding: ItemGridPixabayBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_grid_pixabay, parent, false)
        return ViewHolder(binding)
    }

    fun updatePostList(postList:List<Hit>){
        this.hitList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemGridPixabayBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = PixaBayListViewItemModel()
        fun bind(hit:Hit){

            viewModel.bind(hit)
            binding.viewModel = viewModel
        }
    }

}





