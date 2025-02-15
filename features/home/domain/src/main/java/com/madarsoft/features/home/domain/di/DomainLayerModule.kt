package com.madarsoft.features.home.domain.di

import com.madarsoft.features.home.domain.repo.UsersRepository
import com.madarsoft.features.home.domain.use_cases.AddUserUseCase
import com.madarsoft.features.home.domain.use_cases.GetUserInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideAddUserUseCase(usersRepository: UsersRepository):AddUserUseCase{
        return AddUserUseCase(usersRepository)
    }

    @Provides
    fun provideGetUserInfoUseCase(usersRepository: UsersRepository):GetUserInfoUseCase{
        return GetUserInfoUseCase(usersRepository)
    }

}