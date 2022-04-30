package com.cendrawasih.profile.data.remote.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
	@field:SerializedName("image_cover")
	val imageCover: String? = "",

	@field:SerializedName("image_icon")
	val imageIcon: String? = "",

	@field:SerializedName("name")
	val name: String? = "",

	@field:SerializedName("id")
	val id: String? = ""
)
