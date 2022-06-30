package com.namchok.practiceandroidspotify.datasource

import com.namchok.practiceandroidspotify.datasource.blueprint.SpotifyServiceDatasourceInterface
import com.namchok.practiceandroidmvvm.model.dao.ArtistsDao
import com.namchok.practiceandroidmvvm.model.dao.PlayListDao
import com.namchok.practiceandroidspotify.services.ProjectServiceBase
import retrofit2.Call

class SpotifyServiceDatasource: ProjectServiceBase<SpotifyServiceDatasourceInterface>() {

    var authToken = "Bearer BQB5sYT3BErjjwSlHKH-6ntu3rMGhPn6hykkZ748tpfFXG3ro_YR_W4hJUpI9pWKG5TvU2Wu89PmQ-GUJQUSH8YwePRBHC9L8_DtGJ5jlUpvA2gIFIBF2lykYn9yfspAF7hwo5M_1Y4Qt9S6VMINzZF8Duvy7I5eN542ShtIZDhl59NzzimjA4BAk6NGmE7Fu3xp"

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