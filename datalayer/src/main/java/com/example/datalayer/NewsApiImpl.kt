package com.example.datalayer

import httpClientAndroid
import io.ktor.client.request.get

class NewsApiImpl(): NewsApi {

    override suspend fun getNews(): NewsResponse {
          return httpClientAndroid.get(NewsApi.NEWS_URL)
    }

    override suspend fun getNewsByCategory(): NewsResponse {
        TODO("Not yet implemented")
    }
}