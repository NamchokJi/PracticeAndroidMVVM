package com.namchok.practiceandroidspotify.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ProjectServiceBase<T>{

    protected fun spotifyService(): Retrofit {
        val builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl("https://api.spotify.com/")
                .client(UnsafeOkHttpClient.unsafeOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
        return builder.build()
    }

}

