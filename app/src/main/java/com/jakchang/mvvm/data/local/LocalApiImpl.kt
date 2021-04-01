package com.jakchang.mvvm.data.local

import androidx.lifecycle.LiveData
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity

class LocalApiImpl(
    private val localApi: LocalApi
): LocalApi {

    //////////////////////////////////////////

    override suspend fun selectFavoriteTrackList(): List<FavoriteTrackEntity> {
        return localApi.selectFavoriteTrackList()
    }

    //////////////////////////////////////////

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