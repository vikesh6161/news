package com.example.datalayer

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlin.coroutines.coroutineContext

class NewsRepository(
    private val newsDataSource: NewsDataSource
) {

    private var _newsUiState: MutableStateFlow<Resource<NewsResponse?>> = MutableStateFlow(
        Resource.newInstance(Status.LOADING,
            null
    ))

    val newsUiState = _newsUiState as StateFlow<*>

    suspend fun getAllNews() {
        _newsUiState.value = Resource(Status.LOADING, null)
        val response = newsDataSource.getAllNews()
        _newsUiState.value = Resource.newInstance(Status.SUCCESS, response)
    }

    suspend fun getNewsQuery(query: String) {

    }
}