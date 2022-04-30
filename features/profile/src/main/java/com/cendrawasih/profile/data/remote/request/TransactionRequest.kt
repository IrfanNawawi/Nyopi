package com.cendrawasih.profile.data.remote.request

import com.google.gson.annotations.SerializedName

data class TransactionRequest(
    @SerializedName("payment")
    var payment: String? = null
)