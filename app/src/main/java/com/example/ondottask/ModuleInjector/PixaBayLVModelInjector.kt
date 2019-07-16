package com.example.ondottask.ModuleInjector

import com.example.ondottask.viewModel.PixaBayListViewModel
import com.example.ondottask.api.ApiModule
import dagger.Component
import javax.inject.Singleton



    @Singleton
    @Component(modules = [(ApiModule::class)])
    interface PixaBayLVModelInjector {
        /**
         * Injects required dependencies into the specified PostListViewModel.
         * @param postListViewModel PostListViewModel in which to inject the dependencies
         */
        fun inject(pixaBayListViewModel: PixaBayListViewModel)

        @Component.Builder
        interface Builder {
            fun build(): PixaBayLVModelInjector

            fun networkModule(networkModule: ApiModule): Builder
        }
    }
