package com.cendrawasih.nyopi.data.response

import com.google.gson.annotations.SerializedName

data class CartResponse(

	@field:SerializedName("owner")
	val owner: String? = "",

	@field:SerializedName("amount")
	val amount: Int? = 0,

	@field:SerializedName("product")
	val product: List<ProductResponse?>? = null,

	@field:SerializedName("id")
	val id: String? = ""
)
