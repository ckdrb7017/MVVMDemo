package com.changgyu.watcha.data.local

import androidx.room.Dao
import com.changgyu.watcha.data.local.track.favorite.FavoriteTrackDao
import com.changgyu.watcha.data.local.track.list.TrackListDao

@Dao
interface LocalApi: TrackListDao, FavoriteTrackDao {    //Local에서 사용되는 Api 묶기

}