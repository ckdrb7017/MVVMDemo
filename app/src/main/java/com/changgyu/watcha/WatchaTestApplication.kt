package com.changgyu.watcha

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject


@HiltAndroidApp
class WatchaTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        watchaTestApp = this
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        var watchaTestApp: WatchaTestApplication? = null

    }
}