package com.usjt.projetoa3.data.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): List<User>

    fun getUserStream(login: String, password: String): Flow<User>

    suspend fun insertUser(user: User)
}