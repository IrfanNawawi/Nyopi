package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserInfoResponse(

    @field:SerializedName("city")
    val city: String? = "",

    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("id")
    val id: String? = ""
)