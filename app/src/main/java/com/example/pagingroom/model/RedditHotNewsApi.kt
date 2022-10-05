package com.example.pagingroom.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditHotNewsApi {

    @GET("r/aww/hot.json")
    suspend fun getHotNews(
        @Query("after") after: String?,
        @Query("limit") limit: Int = 25
    ): Response<JsonDTO>
}