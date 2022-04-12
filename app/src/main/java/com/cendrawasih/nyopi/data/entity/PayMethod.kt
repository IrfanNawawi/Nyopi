package com.cendrawasih.nyopi.data.entity

data class PayMethod(
    val paymentType: String = "",
    val code: String = "",
    val isActivated: Boolean = false,
    val name: String = ""
)