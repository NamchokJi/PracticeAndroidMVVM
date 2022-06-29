package com.namchok.practiceandroidmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.namchok.practiceandroidmvvm.model.common.Artist
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidspotify.repository.SpotifyServiceRepository
import com.namchok.practiceandroidspotify.services.RepositoryCallback

class ListArtistViewModel(private var mRepository: SpotifyServiceRepository): ViewModel() {

    var mListArtist = MutableLiveData<ArrayList<Artist>>()

    fun getListArtist(){
        mRepository.getSeveralArtists("3MZsBdqDrRTJihTHQrO6Dq",object :RepositoryCallback<ArtistsDao>{
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

}