package com.cendrawasih.nyopi.data.entity

import com.cendrawasih.nyopi.data.response.ProductResponse

data class Cart(
    val owner: String = "",
    val amount: Int = 0,
    val product: List<ProductResponse> = listOf(),
    val id: String = ""
)