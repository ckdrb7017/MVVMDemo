package com.jakchang.mvvm.data.network

import com.jakchang.mvvm.data.entity.TrackListRequestEntity
import com.jakchang.mvvm.data.entity.TrackListResponseEntity
import retrofit2.Call

interface ServerApi {

    fun getTrackList(request: TrackListRequestEntity): Call<TrackListResponseEntity>
}