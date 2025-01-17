package com.example.kotlintest.RoomCode

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    fun getAllUser(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }
}