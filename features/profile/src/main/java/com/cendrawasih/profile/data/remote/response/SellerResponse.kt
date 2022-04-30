package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class SellerResponse(

	@field:SerializedName("role")
	val role: String? = "",

	@field:SerializedName("full_name")
	val fullName: String? = "",

	@field:SerializedName("simple_address")
	val simpleAddress: String? = "",

	@field:SerializedName("city")
	val city: String? = "",

	@field:SerializedName("image_url")
	val imageUrl: String? = "",

	@field:SerializedName("id")
	val id: String? = "",

	@field:SerializedName("username")
	val username: String? = ""
)
