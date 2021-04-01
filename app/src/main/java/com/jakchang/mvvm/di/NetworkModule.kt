package com.jakchang.mvvm.di

import com.jakchang.mvvm.R
import com.jakchang.mvvm.MyApplication.Companion.myApp
import com.jakchang.mvvm.data.network.ServerApi
import com.jakchang.mvvm.data.network.ServerApiImpl
import com.jakchang.mvvm.data.network.ServerApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ServerApiNetworkSource

    @Singleton
    @Provides
    fun provideOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
    }

    @Singleton
    @Provides
    fun provideApiServerNetwork(okHttpClient: OkHttpClient): ServerApiService {
        return Retrofit.Builder()
            .baseUrl(myApp!!.getString(R.string.server_api_url))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ServerApiService::class.java)
    }

    @Singleton
    @Provides
    @ServerApiNetworkSource
    fun provideApiServerModel(okHttpClient: OkHttpClient): ServerApi {
        return ServerApiImpl(provideApiServerNetwork(okHttpClient))
    }


}