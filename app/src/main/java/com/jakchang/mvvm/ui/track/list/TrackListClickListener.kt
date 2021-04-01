package com.jakchang.mvvm.ui.track.list

import com.jakchang.mvvm.data.entity.TrackEntity

interface TrackListClickListener {
    fun onFavoriteClicked(trackId: Int, trackEntity: TrackEntity)
}