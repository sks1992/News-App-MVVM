package sk.sandeep.newsappmvvm.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import sk.sandeep.newsappmvvm.model.NewsResponse
import sk.sandeep.newsappmvvm.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {
    fun getTopHeadlines(): Flow<NewsResponse> {
        return flow {
            emit(newsApi.getTopHeadlinesNews())
        }.flowOn(Dispatchers.IO)
    }

    fun getRecentNews(searchQuery: String): Flow<NewsResponse> {
        return flow {
            emit(newsApi.getRecentNews(searchQuery))
        }.flowOn(Dispatchers.IO)
    }
}