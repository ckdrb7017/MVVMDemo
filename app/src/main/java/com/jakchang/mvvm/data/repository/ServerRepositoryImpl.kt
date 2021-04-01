package com.jakchang.mvvm.data.repository

import com.jakchang.mvvm.data.entity.TrackListRequestEntity
import com.jakchang.mvvm.data.entity.TrackListResponseEntity
import com.jakchang.mvvm.data.network.ServerApi
import com.jakchang.mvvm.di.NetworkModule.ServerApiNetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServerRepositoryImpl  @Inject constructor(     //Server Repository 인터페이스 구체화
    @ServerApiNetworkSource private val serverApi: ServerApi
): ServerRepository {

    override suspend fun getTrackList(request: TrackListRequestEntity): TrackListResponseEntity {
        var result: TrackListResponseEntity?=null
        withContext(Dispatchers.IO){
            val req = serverApi.getTrackList(request)
            val response = req.await()
            result = response
        }
        return result!!
    }

}