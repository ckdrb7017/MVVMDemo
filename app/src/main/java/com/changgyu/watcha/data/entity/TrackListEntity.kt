package com.changgyu.watcha.data.entity

import java.util.*

data class TrackListRequestEntity(  //서버의 TrackList를 요청하기 위한 data class
    val term: String, val entity: String,
    val limit: Int? = 0, val offset: Int? = 0
)


data class TrackListResponseEntity(  //서버의 TrackList를 응답받기 위한 data class
    val resultCount:Int, val results: ArrayList<TrackEntity>
)


data class TrackEntity( //응답받은 TrackList의 구체적인 데이터 정의 data class
    val artistId: Int, val collectionId: Int, val trackId: Int,
    val artistName: String, val collectionName: String, val trackName: String,
    val artworkUrl100: String?, var isFavorite:Boolean?=false
){
    constructor():this(0, 0,0, "",
        "","", "",false)
}