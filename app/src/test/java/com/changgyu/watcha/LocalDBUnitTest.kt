package com.changgyu.watcha

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.data.local.InitDatabase
import com.changgyu.watcha.data.local.LocalApi
import com.changgyu.watcha.data.local.LocalApiImpl
import com.changgyu.watcha.data.repository.LocalRepositoryImpl
import com.changgyu.watcha.di.LocalDBModule
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Singleton


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class LocalDBUnitTest {

    lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun insertFavoriteTrack() {
        val localApiModel = provideLocalApiModel(provideDataBase(context))
        val localRepository = LocalRepositoryImpl(localApiModel)
        val favoriteTrack = FavoriteTrackEntity(1,1,1,
            "1","1","1")
        CoroutineScope(Dispatchers.IO).launch {
            localRepository.insertFavoriteTrack(favoriteTrack)
        }
    }

    fun provideLocalApiModel(
        database: InitDatabase
    ): LocalApi {
        return LocalApiImpl(
            database.localDao()
        )
    }

    fun provideDataBase(context: Context): InitDatabase {
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