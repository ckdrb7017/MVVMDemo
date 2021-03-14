package com.changgyu.watcha.di

import com.changgyu.watcha.data.repository.LocalRepository
import com.changgyu.watcha.data.repository.LocalRepositoryImpl
import com.changgyu.watcha.data.repository.ServerRepository
import com.changgyu.watcha.data.repository.ServerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {   //Local, Server Repository DI 설정
    @Binds
    abstract fun bindServerRepository(repo: ServerRepositoryImpl): ServerRepository

    @Binds
    abstract fun bindLocalRepository(repo: LocalRepositoryImpl): LocalRepository
}