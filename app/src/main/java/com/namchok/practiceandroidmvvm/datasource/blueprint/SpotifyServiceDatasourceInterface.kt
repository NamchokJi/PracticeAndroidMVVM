package com.namchok.practiceandroidspotify.datasource.blueprint

import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import retrofit2.Call
import retrofit2.http.*

interface SpotifyServiceDatasourceInterface {

    @GET("v1/artists")
    fun getSeveralArtists(@Query("ids") ids: String,@Header("Authorization")authorization:String): Call<ArtistsDao>

}