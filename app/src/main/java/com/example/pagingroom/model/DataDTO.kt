package com.example.pagingroom.model

import com.google.gson.annotations.SerializedName

class DataDTO(
    @SerializedName("after")
    val after: String,
    @SerializedName("dist")
    val dist: Int,
    @SerializedName("modhash")
    val modhash: String,
    @SerializedName("geo_filter")
    val geoFilter: String? = null,
    @SerializedName("children")
    val children: List<ChildrenDataDTO>,
    @SerializedName("before")
    val before: String? = null
)