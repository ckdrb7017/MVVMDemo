package com.changgyu.watcha.data.network

import com.changgyu.watcha.data.entity.TrackListRequestEntity
import com.changgyu.watcha.data.entity.TrackListResponseEntity
import retrofit2.Call

interface ServerApi {

    fun getTrackList(request: TrackListRequestEntity): Call<TrackListResponseEntity>
}