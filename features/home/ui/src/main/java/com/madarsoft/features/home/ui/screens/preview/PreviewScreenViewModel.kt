package com.madarsoft.features.home.ui.screens.preview

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madarsoft.core.common.UiEvent
import com.madarsoft.features.home.domain.model.UserModel
import com.madarsoft.features.home.domain.use_cases.GetUserInfoUseCase
import com.madarsoft.features.home.ui.screens.home.HomeScreenStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreviewScreenViewModel @Inject constructor(private val getUserInfoUseCase: GetUserInfoUseCase):ViewModel(){

    private val _getUserActionState = mutableStateOf<PreviewScreenStateHolder<UserModel>>(PreviewScreenStateHolder.Ideal())
    val getUserActionState: State<PreviewScreenStateHolder<UserModel>> get()=_getUserActionState

    fun getData(){
        viewModelScope.launch {

            getUserInfoUseCase().collectLatest {
                when(it){
                    is UiEvent.Error -> {
                        _getUserActionState.value=PreviewScreenStateHolder.Error()
                    }
                    is UiEvent.Loading -> {
                        _getUserActionState.value=PreviewScreenStateHolder.Loading()
                    }
                    is UiEvent.Success -> {
                        _getUserActionState.value=PreviewScreenStateHolder.Success(it.data!!)
                    }
                }
            }



        }
    }
}