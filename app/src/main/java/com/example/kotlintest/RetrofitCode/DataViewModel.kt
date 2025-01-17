package com.example.kotlintest.RetrofitCode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {

    private val repository = DataRepository()

    private val _posts = MutableLiveData<List<Data>>()
    val posts: LiveData<List<Data>> get() = _posts

    fun fetchPosts(page: Int) {
        viewModelScope.launch {
            try {
                val data = repository.getPosts(page)
                _posts.postValue(data) // Update LiveData with fetched data
            } catch (e: Exception) {
                // Handle error (e.g., network issue, parsing error)
            }
        }
    }

}