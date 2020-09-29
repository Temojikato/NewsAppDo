package com.example.donewsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donewsapp.utility.NewsCenter
import com.example.donewsapp.models.NewsResponse
import com.example.donewsapp.utility.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel (
    val newsCenter: NewsCenter
): ViewModel() {
    var news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    //fix turning
    var newsPage = 1

    init {
        getNews()
    }

    fun getNews() = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val res = newsCenter.getNews()
        news.postValue(handleResponse(res))
    }

    private fun handleResponse(res: Response<NewsResponse>) : Resource<NewsResponse> {
        if (res.isSuccessful){
            res.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(res.message())
    }
}