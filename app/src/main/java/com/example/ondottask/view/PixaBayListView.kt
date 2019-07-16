package com.example.ondottask.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ondottask.R
import com.example.ondottask.viewModel.PixaBayListViewModel
import androidx.recyclerview.widget.GridLayoutManager






class PixaBayListView : AppCompatActivity() {

    private lateinit var binding:com.example.ondottask.databinding.PixaBayListViewBinding
    private lateinit var viewModel:PixaBayListViewModel


            override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

                binding = DataBindingUtil.setContentView(this, R.layout.pixa_bay_list_view)


// set a GridLayoutManager with 3 number of columns
                val gridLayoutManager = GridLayoutManager(applicationContext, 2)
                //gridLayoutManager.orientation = LinearLayoutManager.HORIZONTAL // set Horizontal Orientation
                binding.postList.layoutManager = gridLayoutManager // set LayoutManager to RecyclerView
               // binding.postList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

                viewModel = ViewModelProviders.of(this).get(PixaBayListViewModel::class.java)
                binding.viewModel= viewModel





                binding.searchButtonv.setOnClickListener(View.OnClickListener {
                    Log.d("PixaBayAPI","PixaBayAPI API started on click");
                    viewModel.loadpixaBay(binding.searchlayout.animalsSearchField.text.toString().trim()) ;
                })


    }



}