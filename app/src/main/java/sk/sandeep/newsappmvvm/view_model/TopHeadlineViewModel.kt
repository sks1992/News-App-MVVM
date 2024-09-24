package sk.sandeep.newsappmvvm.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import sk.sandeep.newsappmvvm.model.NewsResponse
import sk.sandeep.newsappmvvm.repository.NewsRepository
import sk.sandeep.newsappmvvm.utils.ApiStatus
import javax.inject.Inject

@HiltViewModel
class TopHeadlineViewModel @Inject constructor(private val newsRepository: NewsRepository) :
    ViewModel() {

    private val topHeadlineStateFlow: MutableStateFlow<ApiStatus<NewsResponse>> =
        MutableStateFlow(ApiStatus.Empty())
    val _topHeadlineFlow: StateFlow<ApiStatus<NewsResponse>> = topHeadlineStateFlow

    fun getTopHeadlines(){
        viewModelScope.launch {
            //initially loading data
            topHeadlineStateFlow.value = ApiStatus.Loading()
            //call api , if anything go wrong catch it and send with failure
            newsRepository.getTopHeadlines().catch { exception ->
                topHeadlineStateFlow.value =ApiStatus.Failure(exception)
            }.collect { data ->
                //collect response and send with Success data
                topHeadlineStateFlow.value =ApiStatus.Success(data)
            }
        }
    }
}

