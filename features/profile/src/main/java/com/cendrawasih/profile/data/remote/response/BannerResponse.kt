package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class BannerResponse(

    @field:SerializedName("image_url")
    val imageUrl: String? = "",

    @field:SerializedName("product_id")
    val productId: String? = "",

    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("caption")
    val caption: String? = "",

    @field:SerializedName("id")
    val id: String? = "",

    @field:SerializedName("headline")
    val headline: String? = "",

    @field:SerializedName("seller_id")
    val sellerId: String? = ""
)
