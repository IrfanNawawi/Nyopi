package com.cendrawasih.nyopi.data.response

import com.google.gson.annotations.SerializedName

data class LoginRegisResponse(
    @field:SerializedName("token")
    val token: String? = ""
)