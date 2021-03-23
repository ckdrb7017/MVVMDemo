package com.changgyu.watcha.common.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.changgyu.watcha.R
import com.changgyu.watcha.common.utils.setImage
import com.changgyu.watcha.common.utils.showLog
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.data.entity.TrackEntity
import com.changgyu.watcha.ui.track.favorite.FavoriteTrackAdapter
import com.changgyu.watcha.ui.track.list.TrackListAdapter

object TrackBindingAdapter {

    @BindingAdapter( "setFavoriteTrackList")    // FavoriteTrackList를 보여주기 위한 BindingAdapter
    @JvmStatic fun setFavoriteTrackList(view: RecyclerView, items: List<FavoriteTrackEntity>?) {
        (view.adapter as FavoriteTrackAdapter).submitList(items)
    }

    @BindingAdapter( "setTrackList")    // 서버로부터온 TrackList를 보여주기 위한 BindingAdapter
    @JvmStatic fun setTrackList(view: RecyclerView, items: List<TrackEntity>?) {
        (view.adapter as TrackListAdapter).submitList(items)
    }

    @BindingAdapter( "setFavoriteIcon") // Favorite아이콘을 설정하는 BindingAdapter
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