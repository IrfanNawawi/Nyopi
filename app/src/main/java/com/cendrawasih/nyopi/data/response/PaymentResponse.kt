package com.cendrawasih.nyopi.data.response

import com.google.gson.annotations.SerializedName

data class PaymentResponse(

    @field:SerializedName("status_payment")
    val statusPayment: String? = "",

    @field:SerializedName("method")
    val method: String? = ""
)