package com.example.ondottask.viewModel


import android.util.Log
import android.view.View
import com.example.ondottask.api.PixaBayApi
import com.example.ondottask.model.PixaBayResponse
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import com.example.ondottask.model.Hit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PixaBayListViewItemModel: BaseViewModel() {

    private val hitTitle = MutableLiveData<String>()
    private val hitImage = MutableLiveData<String>()
    private val hitImageHeight = MutableLiveData<Int>()

    fun bind(hit: Hit){
        hitTitle.value = hit.user
        hitImage.value = hit.previewURL
        hitImageHeight.value = hit.previewWidth
    }

    fun getHitTitle():MutableLiveData<String>{
        return hitTitle
    }

    fun getHitImage():MutableLiveData<String>{
        return hitImage
    }
}