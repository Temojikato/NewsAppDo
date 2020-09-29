package com.example.donewsapp.api

import com.example.donewsapp.models.NewsResponse
import com.example.donewsapp.utility.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = "nl",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}