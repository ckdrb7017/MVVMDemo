package com.changgyu.watcha.data.repository

import androidx.lifecycle.LiveData
import com.changgyu.watcha.data.entity.FavoriteTrackEntity


interface LocalRepository { //Local Repository 인터페이스 정의

    suspend fun selectFavoriteTrackList(): List<FavoriteTrackEntity>

    fun observeFavoriteTrackList(): LiveData<List<FavoriteTrackEntity>>

    suspend fun insertFavoriteTrack(track : FavoriteTrackEntity) : Long

    suspend fun deleteFavoriteTrackById(trackId: Int): Int
}