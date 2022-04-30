package com.cendrawasih.profile.data.remote.request

import com.google.gson.annotations.SerializedName

data class SimulationRequest(
    @SerializedName("reference_id")
    var reference_id: String? = null,
    @SerializedName("amount")
    var amount: Int? = 0
)