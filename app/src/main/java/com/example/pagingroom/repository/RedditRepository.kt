package com.example.pagingroom.repository

import com.example.pagingroom.model.ResponseDTO

interface RedditRepository {
    suspend fun getRedditNews(): ResponseDTO?
}