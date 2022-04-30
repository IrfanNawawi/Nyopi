package com.cendrawasih.profile.data.entity

import com.cendrawasih.profile.data.remote.response.ProductResponse

data class Cart(
    val owner: String = "",
    val amount: Int = 0,
    val product: List<ProductResponse> = listOf(),
    val id: String = ""
)