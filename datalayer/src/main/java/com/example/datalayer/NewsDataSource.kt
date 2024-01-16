package com.example.datalayer

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class NewsDataSource(val api:NewsApi, val coroutineDispatcher: CoroutineDispatcher) {

    suspend fun getAllNews(): NewsResponse {
        return withContext(coroutineDispatcher) {
            api.getNews()
        }
    }

    suspend fun getNewsQuery(query: String): NewsResponse {
        TODO("Not yet implemented")
    }
}