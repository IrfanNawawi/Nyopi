package com.cendrawasih.nyopi.data.response

import com.google.gson.annotations.SerializedName

data class PageResponse<T>(
    @field:SerializedName("data")
    val `data`: List<T?>? = null,

    @field:SerializedName("count_per_page")
    val countPerPage: Int? = 0,

    @field:SerializedName("count")
    val count: Int? = 0,

    @field:SerializedName("current_page")
    val currentPage: Int? = 0
)