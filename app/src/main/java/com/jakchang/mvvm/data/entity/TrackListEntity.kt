package com.jakchang.mvvm.data.entity

import java.util.*

data class TrackListRequestEntity(
    val term: String, val entity: String,
    val limit: Int? = 0, val offset: Int? = 0
)


data class TrackListResponseEntity(
    val resultCount:Int, val results: ArrayList<TrackEntity>
)


data class TrackEntity(
    val artistId: Int, val collectionId: Int, val trackId: Int,
    val artistName: String, val collectionName: String, val trackName: String,
    val artworkUrl100: String?, var isFavorite:Boolean?=false
){
    constructor():this(0, 0,0, "",
        "","", "",false)
}