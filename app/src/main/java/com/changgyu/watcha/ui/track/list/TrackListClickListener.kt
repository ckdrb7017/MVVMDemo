package com.changgyu.watcha.ui.track.list

import com.changgyu.watcha.data.entity.TrackEntity

interface TrackListClickListener {
    fun onFavoriteClicked(trackId: Int, trackEntity: TrackEntity)
}