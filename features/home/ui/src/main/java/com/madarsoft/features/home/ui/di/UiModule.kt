package com.madarsoft.features.home.ui.di

import com.madarsoft.features.home.domain.use_cases.AddUserUseCase
import com.madarsoft.features.home.domain.use_cases.GetUserInfoUseCase
import com.madarsoft.features.home.ui.navigation.HomeApi
import com.madarsoft.features.home.ui.navigation.HomeApiImpl
import com.madarsoft.features.home.ui.screens.home.HomeScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideDashboardApi(): HomeApi {
        return HomeApiImpl()
    }
    @Provides
    fun provideHomeScreenViewModel(addUserUseCase: AddUserUseCase): HomeScreenViewModel {
        return HomeScreenViewModel(addUserUseCase)
    }
}