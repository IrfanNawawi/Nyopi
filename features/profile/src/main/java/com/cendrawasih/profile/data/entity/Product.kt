package com.cendrawasih.profile.data.entity

data class Product(
    val seller: Seller,
    val price: Int = 0,
    val imageUrl: String = "",
    val popularity: Double = 0.0,
    val name: String = "",
    val description: String = "",
    val id: String = "",
    val stock: Int = 0,
    val category: Category,
    val soldCount: Int = 0
)