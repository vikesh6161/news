package com.example.datalayer

interface NewsApi {
    suspend fun getNews(): NewsResponse
    suspend fun getNewsByCategory(): NewsResponse

    companion object {
        const val NEWS_URL = "https://newsapi.org/v2/everything"
    }
}