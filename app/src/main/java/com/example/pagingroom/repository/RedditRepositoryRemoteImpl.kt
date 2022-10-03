package com.example.pagingroom.repository

import com.example.pagingroom.model.ApiFactory
import com.example.pagingroom.model.ResponseDTO

class RedditRepositoryRemoteImpl : RedditRepository {
    private val redditApi = ApiFactory.create()

    override suspend fun getRedditNews(): ResponseDTO? {
        return redditApi.getHotNews(after = "").body()
    }
}