package com.example.kotlintest.RoomCode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserMainViewModelFectory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}