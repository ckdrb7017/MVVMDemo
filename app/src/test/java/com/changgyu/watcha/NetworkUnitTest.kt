package com.changgyu.watcha

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.changgyu.watcha.common.utils.showLog
import com.changgyu.watcha.data.entity.TrackListRequestEntity
import com.changgyu.watcha.data.network.ServerApi
import com.changgyu.watcha.data.network.ServerApiImpl
import com.changgyu.watcha.data.network.ServerApiService
import com.changgyu.watcha.data.repository.ServerRepositoryImpl
import com.changgyu.watcha.di.NetworkModule
import com.changgyu.watcha.ui.track.list.SearchType
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NetworkUnitTest {

    @Test
    fun getTrackList() {
        val okhttpInstance = provideOkhttp()
        val serverApiImpl = provideApiServerModel(okhttpInstance)
        val serverRepository = ServerRepositoryImpl(serverApiImpl)
        val request = TrackListRequestEntity("greenday", SearchType.SONG.type)
        CoroutineScope(Dispatchers.IO).launch {
            serverRepository.getTrackList(request)
        }
    }

    fun provideOkhttp() : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().
            setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

    fun provideApiServerNetwork(okHttpClient: OkHttpClient) : ServerApiService {
        return Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ServerApiService::class.java)
    }

    fun provideApiServerModel(okHttpClient: OkHttpClient): ServerApi {
        return ServerApiImpl(provideApiServerNetwork(okHttpClient))
    }


}