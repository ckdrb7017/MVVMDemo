package com.jakchang.mvvm.data.repository

import com.jakchang.mvvm.data.entity.TrackListRequestEntity
import com.jakchang.mvvm.data.entity.TrackListResponseEntity

interface ServerRepository {    //Server Repository 인터페이스 정의

    suspend fun getTrackList(request: TrackListRequestEntity): TrackListResponseEntity

}