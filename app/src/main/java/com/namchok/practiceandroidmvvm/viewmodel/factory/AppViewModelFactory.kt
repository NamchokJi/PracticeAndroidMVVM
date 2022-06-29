package com.namchok.practiceandroidmvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namchok.practiceandroidmvvm.viewmodel.AppViewModel
import com.namchok.practiceandroidspotify.repository.SpotifyServiceRepository
import java.lang.IllegalArgumentException

class AppViewModelFactory(private var mRepository: SpotifyServiceRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)){
            return AppViewModel(mRepository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel")
    }
}