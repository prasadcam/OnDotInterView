package com.example.ondottask.api

import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@Suppress("unused")

object ApiModule {

    /**
     * Provides the PixaBay service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the PixaBay service implementation.
     */

    @Provides
    @Reusable
    @JvmStatic

   internal fun providePixaBayApi(retrofit:Retrofit):PixaBayApi {

        return  (retrofit.create(PixaBayApi::class.java))
    }

    @Provides
    @Reusable
    @JvmStatic
    internal  fun provideRetrofitInstance():Retrofit {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build() ;


    }
}