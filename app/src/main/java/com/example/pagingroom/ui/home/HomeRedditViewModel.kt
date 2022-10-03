package com.example.pagingroom.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pagingroom.model.ChildrenDataDTO
import com.example.pagingroom.repository.RedditRepository
import kotlinx.coroutines.*

class HomeRedditViewModel(
    private val redditRepository: RedditRepository
) : ViewModel() {

    private val _data: MutableLiveData<List<ChildrenDataDTO>> = MutableLiveData()
    val data: LiveData<List<ChildrenDataDTO>> = _data

    private val coroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, _ ->
            _data.postValue(arrayListOf())
        })

    private var coroutineJob: Job? = null

    fun getData() {
        coroutineJob?.cancel()
        coroutineJob = coroutineScope.launch {
            _data.postValue(redditRepository.getRedditNews()?.data?.children)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}