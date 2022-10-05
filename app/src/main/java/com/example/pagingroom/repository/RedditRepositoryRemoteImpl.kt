package com.example.pagingroom.repository

import com.example.pagingroom.model.ApiFactory
import com.example.pagingroom.model.JsonDTO

class RedditRepositoryRemoteImpl : RedditRepository {
    private val redditApi = ApiFactory.create()

    override suspend fun getRedditNews(after: String?, limit: Int): JsonDTO? {
        return redditApi.getHotNews(after, limit).body()
    }
}