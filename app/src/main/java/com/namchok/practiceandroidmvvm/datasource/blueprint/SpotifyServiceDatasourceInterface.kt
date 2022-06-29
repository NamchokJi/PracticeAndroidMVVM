package com.namchok.practiceandroidspotify.datasource.blueprint

import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidmvvm.model.dao.PlayListDao
import retrofit2.Call
import retrofit2.http.*

interface SpotifyServiceDatasourceInterface {

    @GET("v1/artists")
    fun getSeveralArtists(@Query("ids") ids: String,@Header("Authorization")authorization:String): Call<ArtistsDao>

    @GET("v1/playlists/{ids}/tracks")
    fun getPlaylists(@Path("ids") ids: String, @Query("offset") offset: String, @Query("limit") limit: String,@Query("market") market: String, @Header("Authorization")authorization:String): Call<PlayListDao>

}