package com.namchok.practiceandroidmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.namchok.practiceandroidmvvm.model.common.Artist
import com.namchok.practiceandroidmvvm.model.common.Item
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidmvvm.model.dao.PlayListDao
import com.namchok.practiceandroidspotify.repository.SpotifyServiceRepository
import com.namchok.practiceandroidspotify.services.RepositoryCallback
import androidx.lifecycle.LiveData




class AppViewModel(private var mRepository: SpotifyServiceRepository): ViewModel() {

    var mListArtist = MutableLiveData<ArrayList<Artist>>()
    var mListPlaylist = MutableLiveData<ArrayList<Item>>()

    fun getListArtist(){
        mRepository.getSeveralArtists("3MZsBdqDrRTJihTHQrO6Dq,3mIj9lX2MWuHmhNCA7LSCW",object :RepositoryCallback<ArtistsDao>{
            override fun onPreExecute() {

            }

            override fun onSuccess(result: ArtistsDao?) {
                mListArtist.value = result?.artists
            }

            override fun onFailure(t: Throwable?) {

            }

            override fun onPostExecute() {

            }

        })
    }

    fun getSeveralArtist(): LiveData<ArrayList<Artist>> {
        return mListArtist
    }

    fun getPlaylist(){
        mRepository.getPlaylist("37i9dQZF1DX5trt9i14X7j",object :RepositoryCallback<PlayListDao>{
            override fun onPreExecute() {

            }

            override fun onSuccess(result: PlayListDao?) {
                mListPlaylist.value = result?.items
            }

            override fun onFailure(t: Throwable?) {

            }

            override fun onPostExecute() {

            }

        })
    }

}