package com.cendrawasih.core.remote

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @field:SerializedName("code")
    val code: Int? = 0,

    @field:SerializedName("data")
    val `data`: T? = null,

    @field:SerializedName("message")
    val message: String? = "",

    @field:SerializedName("status")
    val status: Boolean? = false
)