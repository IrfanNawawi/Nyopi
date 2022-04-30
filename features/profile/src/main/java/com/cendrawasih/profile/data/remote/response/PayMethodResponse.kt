package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class PayMethodResponse(

	@field:SerializedName("payment_type")
	val paymentType: String? = "",

	@field:SerializedName("code")
	val code: String? = "",

	@field:SerializedName("is_activated")
	val isActivated: Boolean? = false,

	@field:SerializedName("name")
	val name: String? = ""
)
