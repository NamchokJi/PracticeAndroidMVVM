package com.namchok.practiceandroidspotify.datasource

import com.namchok.practiceandroidspotify.datasource.blueprint.SpotifyServiceDatasourceInterface
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidmvvm.model.dao.PlayListDao
import com.namchok.practiceandroidspotify.services.ProjectServiceBase
import retrofit2.Call

class SpotifyServiceDatasource: ProjectServiceBase<SpotifyServiceDatasourceInterface>() {

    var authToken = "Bearer BQAkIDxPVYzJwXTa-9X9Abu1LEuBxqO0y5o4Xsp_sDLe1n8m68KqB7DbMYcHchbt2LKs_35Dd-Woq1AYSnfQeEoQxPxi5FSA1fn6HstrSFzGZYSBSqpdqEtTqn0uUCNmpkGdwx1Hw-reBm7EKodnPIm8Lq8BbIgGeazQhIR8fTJX7NkSIv8dHUENyqLF1WNYmKAh"

    fun getInterface(): SpotifyServiceDatasourceInterface {
        return spotifyService().create(SpotifyServiceDatasourceInterface::class.java)
    }

    fun getSeveralArtists(id: String): Call<ArtistsDao> {
        return getInterface().getSeveralArtists(id,authToken)
    }

    fun getPlaylists(id: String): Call<PlayListDao> {
        return getInterface().getPlaylists(id,"5","10","ES",authToken)
    }
}