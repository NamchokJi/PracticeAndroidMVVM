package com.namchok.practiceandroidspotify.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonSyntaxException
import com.namchok.practiceandroidmvvm.model.common.Artist
import com.namchok.practiceandroidspotify.datasource.SpotifyServiceDatasource
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidmvvm.model.dao.PlayListDao
import com.namchok.practiceandroidspotify.services.RepositoryCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpotifyServiceRepository {

    var mDataSource = SpotifyServiceDatasource()

    fun getSeveralArtists(id: String, callback: RepositoryCallback<ArtistsDao>) {
        callback.onPreExecute()
        mDataSource.getSeveralArtists(id).enqueue(object :
            Callback<ArtistsDao> {
            override fun onResponse(call: Call<ArtistsDao>?, response: Response<ArtistsDao>?) {
                try {
                    if (response?.code() == 200) {
                        callback.onSuccess(response.body())
                    }
                } catch (e: Exception) {

                    callback.onFailure(e)
                } finally {
                    callback.onPostExecute()
                }
            }

            override fun onFailure(call: Call<ArtistsDao>?, t: Throwable?) {
                if (t is JsonSyntaxException) {
                    callback.onPostExecute()
                } else {
                    if (call?.isCanceled == false) {
                        callback.onFailure(t)
                    }
                    callback.onPostExecute()
                }
            }
        })
    }

    fun getPlaylist(id: String, callback: RepositoryCallback<PlayListDao>) {
        callback.onPreExecute()
        mDataSource.getPlaylists(id).enqueue(object :
            Callback<PlayListDao> {
            override fun onResponse(call: Call<PlayListDao>?, response: Response<PlayListDao>?) {
                try {
                    if (response?.code() == 200) {
                        callback.onSuccess(response.body())
                    }
                } catch (e: Exception) {

                    callback.onFailure(e)
                } finally {
                    callback.onPostExecute()
                }
            }

            override fun onFailure(call: Call<PlayListDao>?, t: Throwable?) {
                if (t is JsonSyntaxException) {
                    callback.onPostExecute()
                } else {
                    if (call?.isCanceled == false) {
                        callback.onFailure(t)
                    }
                    callback.onPostExecute()
                }
            }
        })
    }
}