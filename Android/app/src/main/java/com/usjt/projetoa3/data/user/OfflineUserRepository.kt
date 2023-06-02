package com.usjt.projetoa3.data.user

import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserDao) : UserRepository {
    override fun getAllUsers(): List<User> = userDao.getAllUsers()

    override fun getUserStream(login: String, password: String): Flow<User> = userDao.login(login, password)

    override suspend fun insertUser(user: User) = userDao.insert(user)
}