package com.jakchang.mvvm.di

import com.jakchang.mvvm.data.repository.LocalRepository
import com.jakchang.mvvm.data.repository.LocalRepositoryImpl
import com.jakchang.mvvm.data.repository.ServerRepository
import com.jakchang.mvvm.data.repository.ServerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindServerRepository(repo: ServerRepositoryImpl): ServerRepository

    @Binds
    abstract fun bindLocalRepository(repo: LocalRepositoryImpl): LocalRepository
}