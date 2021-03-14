package com.changgyu.watcha.data.network

import com.changgyu.watcha.data.entity.TrackListRequestEntity
import com.changgyu.watcha.data.entity.TrackListResponseEntity
import retrofit2.Call

class ServerApiImpl(private val service: ServerApiService) : ServerApi {

    override fun getTrackList(request: TrackListRequestEntity): Call<TrackListResponseEntity> {
        // limit이 null이 아니며 0보다 크고, offset이 null이 아니며 -1보다 클때 TrackList Page를 가져오고
        // 아니라면 전체를 가져온다
        if((request.limit?:0) > 0 && (request.offset?:-1) >-1){
            return service.getTrackListPage(term = request.term, entity =request.entity,
                                            limit = request.limit!!, offset = request.offset!!)
        }else{
            return service.getTrackList(term = request.term, entity =request.entity)
        }
    }

}