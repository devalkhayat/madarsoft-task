package com.madarsoft.features.home.data.mappers

import android.util.Log
import com.madarsoft.core.common.Constants
import com.madarsoft.core.datasource.local.entities.Users
import com.madarsoft.features.home.domain.model.UserModel

fun UserModel.toDataSourceInstance():Users{

    return Users(name = this.userName,jobTitle=this.jobTitle,age=this.age,gender=this.gender)
}

fun Users.toDomainInstance():UserModel{
    return UserModel(userName = this.name,jobTitle=this.jobTitle,age=this.age,gender=this.gender)
}

