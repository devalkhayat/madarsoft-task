package com.madarsoft.features.home.ui.screens.home

import com.madarsoft.core.common.UiEvent


sealed class HomeScreenStateHolder {
    data object Ideal:HomeScreenStateHolder()
    data object Loading:HomeScreenStateHolder()
    data object Success:HomeScreenStateHolder()
    data object Error:HomeScreenStateHolder()

}