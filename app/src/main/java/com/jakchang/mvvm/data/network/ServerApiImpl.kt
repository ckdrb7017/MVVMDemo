package com.jakchang.mvvm.data.network

import com.jakchang.mvvm.data.entity.TrackListRequestEntity
import com.jakchang.mvvm.data.entity.TrackListResponseEntity
import retrofit2.Call

class ServerApiImpl(private val service: ServerApiService) : ServerApi {

    override fun getTrackList(request: TrackListRequestEntity): Call<TrackListResponseEntity> {
        if((request.limit?:0) > 0 && (request.offset?:-1) >-1){
            return service.getTrackListPage(term = request.term, entity =request.entity,
                                            limit = request.limit!!, offset = request.offset!!)
        }else{
            return service.getTrackList(term = request.term, entity =request.entity)
        }
    }

}