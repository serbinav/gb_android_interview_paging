package com.example.pagingroom.model

import com.example.pagingroom.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val gson: Gson =
        GsonBuilder()
            .create()

    private val redditApi: RedditHotNewsApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_LOCATIONS)
            .client(
                OkHttpClient.Builder()
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RedditHotNewsApi::class.java)
    }

    fun create(): RedditHotNewsApi = redditApi
}