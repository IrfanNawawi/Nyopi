package com.cendrawasih.nyopi.data.response

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@field:SerializedName("seller")
	val seller: SellerResponse? = null,

	@field:SerializedName("price")
	val price: Int? = 0,

	@field:SerializedName("image_url")
	val imageUrl: String? = "",

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("name")
	val name: String? = "",

	@field:SerializedName("description")
	val description: String? = "",

	@field:SerializedName("id")
	val id: String? = "",

	@field:SerializedName("stock")
	val stock: Int? = 0,

	@field:SerializedName("category")
	val category: CategoryResponse? = null,

	@field:SerializedName("sold_count")
	val soldCount: Int? = 0
)
