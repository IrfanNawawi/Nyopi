package com.cendrawasih.nyopi.data.request

import com.google.gson.annotations.SerializedName

data class SimulationRequest(
    @SerializedName("reference_id")
    var reference_id: String? = null,
    @SerializedName("amount")
    var amount: Int? = 0
)