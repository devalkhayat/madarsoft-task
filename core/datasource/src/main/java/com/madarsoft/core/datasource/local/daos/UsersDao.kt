package com.madarsoft.core.datasource.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.madarsoft.core.datasource.local.entities.Users

@Dao
interface UsersDao {

    @Insert()
    suspend fun Add(user: Users):Unit

    @Query("DELETE FROM tblUsers")
    suspend fun Remove():Unit

    @Query("SELECT  * FROM tblUsers LIMIT 1")
    suspend fun GetInfo():Users
}