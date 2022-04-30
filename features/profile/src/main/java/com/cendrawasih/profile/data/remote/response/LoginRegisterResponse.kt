package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginRegisterResponse(
    @field:SerializedName("token")
    val token: String? = ""
)