package com.cendrawasih.nyopi.data.request

import com.google.gson.annotations.SerializedName

data class LoginRegisterRequest(
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("password")
    var password: String? = null
)