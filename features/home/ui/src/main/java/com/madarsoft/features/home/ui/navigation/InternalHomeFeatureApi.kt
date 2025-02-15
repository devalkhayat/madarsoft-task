package com.madarsoft.features.home.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.madarsoft.core.navigation.HomeFeatureRoutes
import com.madarsoft.core.navigation.NavigationApi
import com.madarsoft.features.home.ui.screens.home.HomeScreen
import com.madarsoft.features.home.ui.screens.preview.PreviewScreen


internal object InternalHomeFeatureApi: NavigationApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {

        navGraphBuilder.navigation<HomeFeatureRoutes.Graph>(startDestination = HomeFeatureRoutes.HomeScreenRoute) {
            composable<HomeFeatureRoutes.HomeScreenRoute> {
                HomeScreen(navController)
            }
            composable<HomeFeatureRoutes.PreviewScreenRoute>(enterTransition = {
                return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(900))
            }, exitTransition = {
                return@composable slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(400))
            }) {
                PreviewScreen(navController)
            }
        }
    }

}