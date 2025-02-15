package com.madarsoft.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeFeatureRoutes{
    @Serializable
    data object Graph:HomeFeatureRoutes()
    @Serializable
    data object HomeScreenRoute:HomeFeatureRoutes()
    @Serializable
    data object PreviewScreenRoute:HomeFeatureRoutes()
}