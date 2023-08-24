package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val postViewModel:PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()
        postViewModel.errLiveData.observe(this, Observer { err->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })

        postViewModel.postLiveData.observe(this, Observer { productsList->
            binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
             binding.rvRecycler.layoutManager = GridLayoutManager(this@MainActivity, 1)



        })
    }
}