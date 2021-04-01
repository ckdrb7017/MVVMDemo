package com.jakchang.mvvm.data.repository

import androidx.lifecycle.LiveData
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity
import com.jakchang.mvvm.data.local.LocalApi
import com.jakchang.mvvm.di.LocalDBModule.LocalApiDatabaseSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepositoryImpl @Inject constructor(  //Local Repository 인터페이스 구체화
    @LocalApiDatabaseSource private val localApi: LocalApi
): LocalRepository {

    override suspend fun selectFavoriteTrackList(): List<FavoriteTrackEntity> {
        return localApi.selectFavoriteTrackList()
    }

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