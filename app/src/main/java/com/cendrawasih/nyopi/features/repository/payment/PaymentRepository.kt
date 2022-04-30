package com.cendrawasih.nyopi.features.repository.payment

import com.cendrawasih.core.event.StateEventManager
import com.cendrawasih.profile.data.entity.PayMethod
import com.cendrawasih.profile.data.entity.Payment
import com.cendrawasih.profile.data.remote.request.PaymentRequest
import java.io.Closeable

interface PaymentRepository : Closeable {
    val currentPaymentStateEventManager: StateEventManager<Payment>
    val allPaymentStateEventManager: StateEventManager<Payment>
    val createPaymentStateEventManager: StateEventManager<Payment>
    val allPaymentMethodStateEventManager: StateEventManager<PayMethod>

    fun get_current_payment(currentPaymentRequest: PaymentRequest)
    fun get_all_payment()
    fun get_create_payment(createPaymentRequest: PaymentRequest)
    fun get_all_payment_method()
}