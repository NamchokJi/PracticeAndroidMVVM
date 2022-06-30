package com.namchok.practiceandroidmvvm.di

import com.namchok.practiceandroidmvvm.viewmodel.AppViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val spotifyModule = module {
    viewModel { AppViewModel(get()) }
}