package com.example.pagingroom.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagingroom.paging.RedditPagingSource
import com.example.pagingroom.repository.RedditRepository

class HomeRedditViewModel(
    private val redditRepository: RedditRepository
) : ViewModel() {

    val newsPager = Pager(
        PagingConfig(pageSize = 25)
    ) {
        RedditPagingSource(redditRepository)
    }.flow.cachedIn(viewModelScope)
}