package com.example.pagingroom.model

import com.google.gson.annotations.SerializedName

class DataChildrenDTO (
    @SerializedName("thumbnail")
    val thumbnailImage: String,
    @SerializedName("num_comments")
    val numCommentsMessage: Int,
    @SerializedName("title")
    val titleText: String,
    @SerializedName("score")
    val scoreStar: Int
)