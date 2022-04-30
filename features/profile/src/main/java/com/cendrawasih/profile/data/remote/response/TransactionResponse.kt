package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class TransactionResponse(

	@field:SerializedName("cart_id")
	val cartId: String? = "",

	@field:SerializedName("amount")
	val amount: Int? = 0,

	@field:SerializedName("updated_at")
	val updatedAt: String? = "",

	@field:SerializedName("group_id")
	val groupId: String? = "",

	@field:SerializedName("payment_response")
	val paymentResponse: PaymentResponse? = null,

	@field:SerializedName("status_transaction")
	val statusTransaction: String? = "",

	@field:SerializedName("created_at")
	val createdAt: String? = "",

	@field:SerializedName("id")
	val id: String? = "",

	@field:SerializedName("product_data")
	val productData: List<ProductDataResponse?>? = null,

	@field:SerializedName("customer_id")
	val customerId: String? = "",

	@field:SerializedName("seller_id")
	val sellerId: String? = ""
)
