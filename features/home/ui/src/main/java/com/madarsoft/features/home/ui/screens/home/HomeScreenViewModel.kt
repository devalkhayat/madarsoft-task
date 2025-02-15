package com.madarsoft.features.home.ui.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madarsoft.core.common.UiEvent
import com.madarsoft.core.common.components.GenderTypes
import com.madarsoft.features.home.domain.model.UserModel
import com.madarsoft.features.home.domain.use_cases.AddUserUseCase
import com.madarsoft.features.home.domain.use_cases.GetUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val addUserUseCase: AddUserUseCase):ViewModel() {

    private val _addUserActionState = mutableStateOf<HomeScreenStateHolder>(HomeScreenStateHolder.Ideal)
    val addUserActionState:State<HomeScreenStateHolder> get()=_addUserActionState

    private val _userInputInfo = mutableStateOf<UserInput>(UserInput())
    val userInputInfo:State<UserInput> get()=_userInputInfo

    fun add(){
        viewModelScope.launch {

            addUserUseCase(_userInputInfo.value.toUserModel()).collectLatest {
                when(it){
                    is UiEvent.Error -> {
                        _addUserActionState.value=HomeScreenStateHolder.Error
                    }
                    is UiEvent.Loading -> {
                        _addUserActionState.value=HomeScreenStateHolder.Loading
                    }
                    is UiEvent.Success -> {
                        _addUserActionState.value=HomeScreenStateHolder.Success
                    }
                }
            }



        }
    }
}

data class UserInput(var name:String?=null, var jobTitle:String?=null, var age:Int=0, var gender:String?=GenderTypes.Male.value){
    fun toUserModel()=UserModel(userName = name!!,jobTitle=jobTitle!!,age=age,gender=gender!!)
}





