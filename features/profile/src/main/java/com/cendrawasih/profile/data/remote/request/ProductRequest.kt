package com.cendrawasih.profile.data.remote.request

import com.google.gson.annotations.SerializedName

data class ProductRequest(
    @SerializedName("productId")
    var productId: String? = null,
)