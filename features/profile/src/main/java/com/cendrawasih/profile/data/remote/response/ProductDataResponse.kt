package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductDataResponse(

    @field:SerializedName("product")
    val product: ProductResponse? = null,

    @field:SerializedName("quantity")
    val quantity: Int? = 0,

    @field:SerializedName("updated_at")
    val updatedAt: String? = "",

    @field:SerializedName("created_at")
    val createdAt: String? = ""
)