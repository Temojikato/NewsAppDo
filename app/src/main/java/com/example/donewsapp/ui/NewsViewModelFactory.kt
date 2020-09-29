package com.example.donewsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.donewsapp.utility.NewsCenter

class NewsViewModelFactory(
    val newsCenter : NewsCenter
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsCenter) as T
    }
}