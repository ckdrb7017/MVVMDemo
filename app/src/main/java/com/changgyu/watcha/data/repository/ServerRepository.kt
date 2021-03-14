package com.changgyu.watcha.data.repository

import com.changgyu.watcha.data.entity.TrackListRequestEntity
import com.changgyu.watcha.data.entity.TrackListResponseEntity

interface ServerRepository {    //Server Repository 인터페이스 정의

    suspend fun getTrackList(request: TrackListRequestEntity): TrackListResponseEntity

}