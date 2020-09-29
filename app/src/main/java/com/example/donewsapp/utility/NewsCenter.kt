package com.example.donewsapp.utility

import com.example.donewsapp.api.RetrofitClient

class NewsCenter {
    suspend fun getNews() =
        RetrofitClient.api.getNews()
}