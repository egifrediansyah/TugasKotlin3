package com.android.tugaskotlin3.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.tugaskotlin3.Model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

}
