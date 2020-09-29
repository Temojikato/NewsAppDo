package com.example.donewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.donewsapp.utility.NewsCenter
import com.example.donewsapp.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsCenter = NewsCenter()
        val viewFactory = NewsViewModelFactory(newsCenter)
        viewModel = ViewModelProvider(this, viewFactory).get(NewsViewModel::class.java)
    }
}