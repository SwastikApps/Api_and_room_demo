package com.example.kotlintest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintest.RetrofitCode.DataAdapter
import com.example.kotlintest.RetrofitCode.DataViewModel
import com.example.kotlintest.databinding.ActivityMainBinding

class MainActivity  : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    lateinit var dao: UserDao
//    lateinit var repository: UserRepository
//    lateinit var mainviewmodel: UserViewModel

    lateinit var adapter: DataAdapter

    private lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel =
            ViewModelProvider(this).get(DataViewModel::class.java)

        adapter = DataAdapter(this, emptyList())
        binding.listview.layoutManager = LinearLayoutManager(this)
        binding.listview.adapter = adapter

        viewModel.posts.observe(this) { posts ->
            adapter.updateData(posts)
            Log.d("TAG", "onCreate: " + posts.toString())
        }
        viewModel.fetchPosts(1)

//        dao = UserDatabase.getDatabase(this).userDao()
//        repository = UserRepository(dao)
//
//        mainviewmodel = ViewModelProvider(
//            this,
//            UserMainViewModelFectory(repository)
//        ).get(UserViewModel::class.java)
//
//        mainviewmodel.getUsers().observe(this, {
//            binding.user = it.toString()
//        })
//
//        binding.submit.setOnClickListener {
//            val uu = User(0, "jaydeep parmar", 25)
//            mainviewmodel.insert(uu)
//        }

    }
}