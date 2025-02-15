package com.madarsoft.features.home.ui.screens.preview

import com.madarsoft.features.home.domain.model.UserModel

sealed class PreviewScreenStateHolder<T>(val rs:T?=null) {
     class Ideal<T>():PreviewScreenStateHolder<T>()
     class Loading<T>():PreviewScreenStateHolder<T>()
     class Error<T>():PreviewScreenStateHolder<T>()
     class Success<T>( data:T):PreviewScreenStateHolder<T>(rs=data)

}

