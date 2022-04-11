package com.cendrawasih.nyopi.data.request

import com.google.gson.annotations.SerializedName

data class SellerRequest(
    @SerializedName("productId")
    var productId: String? = null,
)