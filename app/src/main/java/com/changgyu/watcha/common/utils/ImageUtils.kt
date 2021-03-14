package com.changgyu.watcha.common.utils

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.changgyu.watcha.R

//이미지관련 유틸

fun setImage(context: Context, imageSource: Any?, imageView: ImageView) {
    var uri = Uri.parse("")
    when (imageSource) {
        is String -> {
            uri = Uri.parse(imageSource)
        }
        is Uri -> {
            uri = imageSource
        }
        is Int -> {
            uri = Uri.parse(context.getString(R.string.resource_path) + "drawable/" + imageSource)
        }
    }
    Glide.with(context)
        .load(uri)
        .error(R.mipmap.ic_launcher_round)
        .centerInside()
        .into(imageView)
}