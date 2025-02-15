package com.madarsoft.features.home.domain.use_cases

import com.madarsoft.core.common.UiEvent
import com.madarsoft.features.home.domain.model.UserModel
import com.madarsoft.features.home.domain.repo.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val usersRepository: UsersRepository) {

    operator fun invoke() = flow<UiEvent<UserModel>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(usersRepository.getUserData()))
    }.catch() {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}