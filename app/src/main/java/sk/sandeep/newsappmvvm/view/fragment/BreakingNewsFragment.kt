package sk.sandeep.newsappmvvm.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import sk.sandeep.newsappmvvm.R
import sk.sandeep.newsappmvvm.utils.ApiStatus
import sk.sandeep.newsappmvvm.view_model.TopHeadlineViewModel

@AndroidEntryPoint
class BreakingNewsFragment : Fragment() {
    private val topHeadlineViewModel: TopHeadlineViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        topHeadlineViewModel.getTopHeadlines()
        lifecycleScope.launch {
            topHeadlineViewModel._topHeadlineFlow.collect { apiState ->
                when (apiState) {
                    is ApiStatus.Empty -> {
                        Log.d("SK", "ApiStatus.Empty")
                    }
                    is ApiStatus.Failure -> {
                        Log.d("SK", "ApiStatus.Failure")
                    }
                    is ApiStatus.Loading -> {
                        Log.d("SK", "ApiStatus.Loading")
                    }
                    is ApiStatus.Success -> {
                        Log.d("SK", "ApiStatus.Success")
                    }
                }
            }
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breaking_news, container, false)

    }

    fun init() {

    }
}