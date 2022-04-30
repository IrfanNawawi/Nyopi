package com.cendrawasih.profile.data.remote.request

import com.google.gson.annotations.SerializedName

data class PaymentRequest(
    @SerializedName("transaction_id")
    var transaction_id: String? = null,
)