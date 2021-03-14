package com.changgyu.watcha.data.local.track.list

import androidx.lifecycle.LiveData
import androidx.room.*
import com.changgyu.watcha.data.entity.FavoriteTrackEntity

@Dao
interface TrackListDao {

    @Query("select * from favorite_track")  //favoriteTrackList 데이터를 가져오는 쿼리
    suspend fun selectFavoriteTrackList() : List<FavoriteTrackEntity>

}