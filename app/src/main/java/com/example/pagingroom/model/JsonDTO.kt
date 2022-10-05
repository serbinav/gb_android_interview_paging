package com.example.pagingroom.model

import com.google.gson.annotations.SerializedName

class JsonDTO(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("data")
    val data: DataDTO
)