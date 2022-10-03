package com.example.pagingroom.di

import com.example.pagingroom.repository.RedditRepository
import com.example.pagingroom.repository.RedditRepositoryRemoteImpl
import com.example.pagingroom.ui.home.HomeRedditViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Repository
    single<RedditRepository> { RedditRepositoryRemoteImpl() }

    // View model
    viewModel { HomeRedditViewModel(redditRepository = get()) }
}