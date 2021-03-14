package com.changgyu.watcha.common.utils

import android.content.Context
import android.widget.Toast
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

//공통으로 사용되는 유틸

fun showToast(context: Context, message: Any) {
    Toast.makeText(context, message.toString(), Toast.LENGTH_SHORT).show()
}

fun showLog(message: Any) {
    Timber.d(message.toString())
}

fun getCurrentTime(): String{
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(System.currentTimeMillis())
}