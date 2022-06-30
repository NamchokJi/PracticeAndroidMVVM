package com.namchok.practiceandroidmvvm

import android.app.Application
import com.namchok.practiceandroidmvvm.di.spotifyModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(spotifyModule)
        }
    }
}