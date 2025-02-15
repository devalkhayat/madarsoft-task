package com.madarsoft.features.home.data.repo

import com.madarsoft.core.datasource.local.AppDatabase
import com.madarsoft.features.home.data.mappers.toDataSourceInstance
import com.madarsoft.features.home.data.mappers.toDomainInstance
import com.madarsoft.features.home.domain.model.UserModel
import com.madarsoft.features.home.domain.repo.UsersRepository
import javax.inject.Inject

class UsersRepoImpl @Inject constructor(private val db: AppDatabase):UsersRepository {
    override suspend fun getUserData(): UserModel = db.usersDao().GetInfo().toDomainInstance()
    override suspend fun addNew(user: UserModel): Boolean {

        try {
            db.usersDao().apply {
                this.Remove()
                this.Add(user.toDataSourceInstance())
            }
            return true
        } catch(ex:Exception) {
            return false
        }
    }


}