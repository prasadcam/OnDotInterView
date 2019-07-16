package com.example.ondottask.viewModel


import android.util.Log
import android.view.View
import com.example.ondottask.api.PixaBayApi
import com.example.ondottask.model.PixaBayResponse
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import com.example.ondottask.adapter.PixaBayListViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PixaBayListViewModel: BaseViewModel() {

    @Inject
    lateinit var pixaBayApi: PixaBayApi;
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val listVisibility: MutableLiveData<Int> = MutableLiveData()
    val searchVisibility: MutableLiveData<Int> = MutableLiveData()


    val pixaBayListViewAdapter: PixaBayListViewAdapter = PixaBayListViewAdapter()

    private  var mutableLiveData: MutableLiveData<PixaBayResponse> = MutableLiveData()  ;

    init{
       // loadpixaBay("animal")
        loadingVisibility.value = View.GONE ;
        searchVisibility.value = View.VISIBLE;
        Log.d("PixaBayAPI","PixaBayAPI API Model started");
    }

     fun loadpixaBay(str:String?){

        Log.d("PixaBayAPI","PixaBayAPI API started " +str);


        loadingVisibility.value = View.VISIBLE ;

        listVisibility.value = View.GONE ;


        val map = HashMap<String,String>();
        map.put("key", "3968517-94dbe52e08b9ec52249a64fdc");
         if (str != null) {
             map.put("q", str)
         }
         else{
             map.put("q", "animal")
         };
        map.put("image_type","all");
        map.put("page","1");


        val call = pixaBayApi.getImagesFromPixaBay(map)
        call.enqueue(object : Callback<PixaBayResponse> {

     override fun onResponse(call: Call<PixaBayResponse>, response: Response<PixaBayResponse>) {
                val pixabayResponse = response.body()
         loadingVisibility.value = View.GONE ;
             if(pixabayResponse!=null) {
                 mutableLiveData.value  =     pixabayResponse   ;
                 val hits = pixabayResponse.hits;

                 Log.d("PixaBayAPI","PixaBayAPI api loeaded result " +hits?.get(0)?.previewHeight

                 + " "+hits?.get(0)?.previewWidth);

                 Log.d("PixaBayAPI","PixaBayAPI api mutableLiveData " +mutableLiveData.value);

                     mutableLiveData.value!!.hits?.let { pixaBayListViewAdapter.updatePostList(it) }
                     listVisibility.value = View.VISIBLE ;
                 searchVisibility.value = View.GONE;

             }

            }

            override  fun onFailure(call: Call<PixaBayResponse>, t: Throwable) {
                Log.d("PixaBayAPI","PixaBayAPI api on error " +t.message);
                loadingVisibility.value = View.GONE ;
            }
        })




    }

     fun onLoginClick():String{

        Log.d("Pixabay","PixaBayAPI on login button clicked")

         return "" ;

    }

    override fun onCleared() {
        super.onCleared()


    }
}