package com.namchok.practiceandroidspotify.datasource

import com.namchok.practiceandroidspotify.datasource.blueprint.SpotifyServiceDatasourceInterface
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidspotify.services.ProjectServiceBase
import retrofit2.Call

class SpotifyServiceDatasource: ProjectServiceBase<SpotifyServiceDatasourceInterface>() {

    fun getInterface(): SpotifyServiceDatasourceInterface {
        return spotifyService().create(SpotifyServiceDatasourceInterface::class.java)
    }

    fun getSeveralArtists(id: String): Call<ArtistsDao> {
        return getInterface().getSeveralArtists(id,"Bearer BQCMDnycoJ5HdCZwmTTyhWRFc4m5JUhuGYDfRf4DSu4m7TdYEwH5gJ7If8yHcsNhkQLm8uzP7aVZjmivU3XwYgNLiRcM3DCUv9hx6jkMMccFXw9ftSl3ppjml5JkMCpESQeurl8lWVkWP5hvLK0EEdrEmipvu4H5XjAF5PdJuGDwMV0Rb4tQGKblJFpFwrcB5UMo")
    }
}