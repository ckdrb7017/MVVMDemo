package com.jakchang.mvvm.data.local

import androidx.room.Dao
import com.jakchang.mvvm.data.local.track.favorite.FavoriteTrackDao
import com.jakchang.mvvm.data.local.track.list.TrackListDao

@Dao
interface LocalApi: TrackListDao, FavoriteTrackDao {

}