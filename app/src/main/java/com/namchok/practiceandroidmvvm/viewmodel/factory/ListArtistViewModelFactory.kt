package com.namchok.practiceandroidmvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namchok.practiceandroidmvvm.viewmodel.ListArtistViewModel
import com.namchok.practiceandroidspotify.repository.SpotifyServiceRepository
import java.lang.IllegalArgumentException

class ListArtistViewModelFactory(private var mRepository: SpotifyServiceRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListArtistViewModel::class.java)){
            return ListArtistViewModel(mRepository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel")
    }
}