package com.jakchang.mvvm.data.local.track.favorite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity

@Dao
interface FavoriteTrackDao {

    @Query("select * from favorite_track")  //favoriteTrackList 데이터를 Observing하며 가져오는 쿼리
    fun observeFavoriteTrackList() : LiveData<List<FavoriteTrackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)    //favoriteTrack 데이터를 삽입하는 쿼리
    suspend fun insertFavoriteTrack(track : FavoriteTrackEntity) : Long

    @Query("delete from favorite_track where track_id =:trackId")   //favoriteTrack 데이터를 제거하는 쿼리
    suspend fun deleteFavoriteTrackById(trackId: Int): Int
}