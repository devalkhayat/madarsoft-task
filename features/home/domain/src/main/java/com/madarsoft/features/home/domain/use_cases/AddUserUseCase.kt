package com.madarsoft.features.home.domain.use_cases

import android.util.Log
import com.madarsoft.core.common.UiEvent
import com.madarsoft.features.home.domain.model.UserModel
import com.madarsoft.features.home.domain.repo.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddUserUseCase @Inject constructor(private val usersRepository: UsersRepository) {
    operator fun invoke(model: UserModel) = flow<UiEvent<Boolean>> {
        emit(UiEvent.Loading())
        delay(2000L)
        emit(UiEvent.Success(usersRepository.addNew(model)))
    }.catch() {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}