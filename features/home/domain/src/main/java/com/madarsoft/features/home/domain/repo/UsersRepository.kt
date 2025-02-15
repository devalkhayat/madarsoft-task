package com.madarsoft.features.home.domain.repo

import com.madarsoft.features.home.domain.model.UserModel

interface UsersRepository {
    suspend fun getUserData(): UserModel
    suspend fun addNew(user:UserModel): Boolean
}