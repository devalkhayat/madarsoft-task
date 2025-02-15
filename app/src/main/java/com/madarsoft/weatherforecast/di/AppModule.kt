package com.madarsoft.task.di

import com.madarsoft.features.home.ui.navigation.HomeApi
import com.madarsoft.task.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

  @Provides
    fun provideNavigationProvider(homeApi: HomeApi
    ): NavigationProvider {
        return NavigationProvider(homeApi)
    }
}