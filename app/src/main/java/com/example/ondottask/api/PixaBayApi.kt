package com.example.ondottask.api


import androidx.lifecycle.MutableLiveData
import com.example.ondottask.model.PixaBayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PixaBayApi {


    @GET("api")
    fun getImagesFromPixaBay  ( @QueryMap parameter:Map<String,String> ):Call<PixaBayResponse>
}