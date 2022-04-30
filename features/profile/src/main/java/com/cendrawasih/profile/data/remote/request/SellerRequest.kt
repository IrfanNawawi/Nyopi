package com.cendrawasih.profile.data.remote.request

import com.google.gson.annotations.SerializedName

data class SellerRequest(
    @SerializedName("productId")
    var productId: String? = null,
)