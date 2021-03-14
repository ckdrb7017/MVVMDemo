package com.changgyu.watcha.data.local

import androidx.lifecycle.LiveData
import com.changgyu.watcha.data.entity.FavoriteTrackEntity

class LocalApiImpl(
    private val localApi: LocalApi
): LocalApi {

    ////////////////////////////////////////// TrackList에 사용되는 api

    override suspend fun selectFavoriteTrackList(): List<FavoriteTrackEntity> {
        return localApi.selectFavoriteTrackList()
    }

    ////////////////////////////////////////// FavoriteTrack에 사용되는 api

    override fun observeFavoriteTrackList(): LiveData<List<FavoriteTrackEntity>> {
        return localApi.observeFavoriteTrackList()
    }

    override suspend fun insertFavoriteTrack(track: FavoriteTrackEntity): Long {
        return localApi.insertFavoriteTrack(track)
    }

    override suspend fun deleteFavoriteTrackById(trackId: Int): Int {
        return localApi.deleteFavoriteTrackById(trackId)
    }
}