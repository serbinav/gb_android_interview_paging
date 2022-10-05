package com.example.pagingroom.model

import com.google.gson.annotations.SerializedName

data class ChildrenDataDTO (
    @SerializedName("kind")
    val kind: String,
    @SerializedName("data")
    val data: EndUnitDTO
)