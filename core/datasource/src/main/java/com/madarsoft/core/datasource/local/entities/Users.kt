package com.madarsoft.core.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblUsers")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val name:String,
    val jobTitle:String,
    val age:Int,
    val gender:String
)
