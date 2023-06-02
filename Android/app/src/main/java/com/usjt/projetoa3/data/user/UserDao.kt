package com.usjt.projetoa3.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM usuarios")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM usuarios WHERE login = :login AND senha = :password")
    fun login(login: String, password: String): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
}