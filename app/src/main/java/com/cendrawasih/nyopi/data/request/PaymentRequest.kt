package com.cendrawasih.nyopi.data.request

import com.google.gson.annotations.SerializedName

data class PaymentRequest(
    @SerializedName("transaction_id")
    var transaction_id: String? = null,
)