package com.jakchang.mvvm.data.network

import com.jakchang.mvvm.data.entity.TrackListResponseEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ServerApiService {

    @GET("search")
    fun getTrackList(@Query("term") term: String,
                         @Query("entity") entity: String): Call<TrackListResponseEntity>

    @GET("search")
    fun getTrackListPage(@Query("term") term: String,
                               @Query("entity") entity: String,
                               @Query("limit") limit: Int,
                               @Query("offset") offset: Int): Call<TrackListResponseEntity>
}