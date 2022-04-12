package com.cendrawasih.nyopi.data.request

import com.google.gson.annotations.SerializedName

data class TransactionRequest(
    @SerializedName("payment")
    var payment: String? = null
)