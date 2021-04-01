package com.jakchang.mvvm.common.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakchang.mvvm.R
import com.jakchang.mvvm.common.utils.setImage
import com.jakchang.mvvm.common.utils.showLog
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity
import com.jakchang.mvvm.data.entity.TrackEntity
import com.jakchang.mvvm.ui.track.favorite.FavoriteTrackAdapter
import com.jakchang.mvvm.ui.track.list.TrackListAdapter

object TrackBindingAdapter {

    @BindingAdapter( "setFavoriteTrackList")
    @JvmStatic fun setFavoriteTrackList(view: RecyclerView, items: List<FavoriteTrackEntity>?) {
        (view.adapter as FavoriteTrackAdapter).submitList(items)
    }

    @BindingAdapter( "setTrackList")
    @JvmStatic fun setTrackList(view: RecyclerView, items: List<TrackEntity>?) {
        (view.adapter as TrackListAdapter).submitList(items)
    }

    @BindingAdapter( "setFavoriteIcon")
    @JvmStatic fun setFavoriteIcon(view: ImageView, item: TrackEntity?) {
       if(item!!.isFavorite!!){
           setImage(view.context,  R.drawable.icon_favorite_trck_selected, view)
       }else{
           setImage(view.context, R.drawable.icon_favorite_trck_unselected, view)
       }
    }

    @BindingAdapter( "setImage")
    @JvmStatic fun setImage(view: ImageView, url: String) {
        setImage(view.context, url, view)
    }

}