package com.android.tugaskotlin3.Database

import androidx.room.*
import com.android.tugaskotlin3.Model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User where email= :mail and password= :password")
    fun getUser(mail: String, password: String): User

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}