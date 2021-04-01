package com.jakchang.mvvm.data.entity

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "favorite_track")
data class FavoriteTrackEntity(
    @PrimaryKey
    @ColumnInfo(name = "track_id") val trackId: Int,
    @ColumnInfo(name = "collection_id") val collectionId: Int,
    @ColumnInfo(name = "artist_id") val artistId: Int,
    @ColumnInfo(name = "track_name") val trackName: String ?= "",
    @ColumnInfo(name = "collection_name") val collectionName: String ?= "",
    @ColumnInfo(name = "artist_name") val artistName: String ?= "",
    @ColumnInfo(name = "artwork_url") var artworkUrl : String ?= "",
    @ColumnInfo(name = "created_date") var createdDate: String?=""
)