package com.madarsoft.features.home.data.di

import com.madarsoft.core.datasource.local.AppDatabase
import com.madarsoft.features.home.data.repo.UsersRepoImpl
import com.madarsoft.features.home.domain.repo.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideUsersRepo(db: AppDatabase):UsersRepository=  UsersRepoImpl(db)

}