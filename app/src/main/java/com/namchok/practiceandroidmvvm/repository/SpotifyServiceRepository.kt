package com.namchok.practiceandroidspotify.repository

import com.google.gson.JsonSyntaxException
import com.namchok.practiceandroidspotify.datasource.SpotifyServiceDatasource
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidspotify.services.RepositoryCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpotifyServiceRepository {

    private var mDataSource = SpotifyServiceDatasource()

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
}