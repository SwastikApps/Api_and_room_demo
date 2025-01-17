package com.example.kotlintest.RoomCode

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun getUsers(): LiveData<List<User>> {
        return repository.getAllUser()
    }

    fun insert(note: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(note)
        }
    }

    fun delete(note: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(note)
        }
    }

}