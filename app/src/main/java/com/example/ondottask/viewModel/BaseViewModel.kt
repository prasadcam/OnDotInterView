package com.example.ondottask.viewModel

import androidx.lifecycle.ViewModel
import com.example.ondottask.ModuleInjector.DaggerPixaBayLVModelInjector
import com.example.ondottask.ModuleInjector.PixaBayLVModelInjector

import com.example.ondottask.api.ApiModule


abstract  class BaseViewModel : ViewModel() {

 // write common logics here

  private val injector: PixaBayLVModelInjector = DaggerPixaBayLVModelInjector
        .builder()
        .networkModule(ApiModule)
        .build()

    init {
        inject()
    }

     /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PixaBayListViewModel -> injector.inject(this)
        }
    }





}