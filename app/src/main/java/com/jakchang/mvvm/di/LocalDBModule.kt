package com.jakchang.mvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jakchang.mvvm.data.local.InitDatabase
import com.jakchang.mvvm.data.local.LocalApi
import com.jakchang.mvvm.data.local.LocalApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDBModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalApiDatabaseSource

    @Singleton
    @Provides
    @LocalApiDatabaseSource
    fun provideLocalApiModel(
        database: InitDatabase
    ): LocalApi {
        return LocalApiImpl(
            database.localDao()
        )
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): InitDatabase {
        return Room.databaseBuilder(
            context,
            InitDatabase::class.java,
            "watchatest.db"
        ) .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }).allowMainThreadQueries()
            .setJournalMode(RoomDatabase.JournalMode.AUTOMATIC)
            .enableMultiInstanceInvalidation()
            .build()
    }
}