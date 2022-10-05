package com.example.pagingroom.repository

import com.example.pagingroom.model.JsonDTO

interface RedditRepository {
    suspend fun getRedditNews(after: String?, limit: Int): JsonDTO?
}