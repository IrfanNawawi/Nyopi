package com.cendrawasih.nyopi.features.repository.payment

import com.cendrawasih.core.util.mapObservable
import com.cendrawasih.profile.data.ProfileMapper
import com.cendrawasih.profile.data.entity.PayMethod
import com.cendrawasih.profile.data.entity.Payment
import com.cendrawasih.profile.data.remote.ProfileWebServices
import com.cendrawasih.profile.data.remote.request.PaymentRequest
import io.reactivex.Observable

class PaymentDataSource(private val profileWebServices: ProfileWebServices) {
    fun get_current_payment(currentPaymentRequest: PaymentRequest): Observable<Payment> {
        return profileWebServices.get_current_payment(currentPaymentRequest)
            .mapObservable { currentPaymentResponse ->
                ProfileMapper.mapPaymentToEntity(currentPaymentResponse)
            }
    }

    fun get_all_payment(): Observable<Payment> {
        return profileWebServices.get_all_payment().mapObservable { allPaymentResponse ->
            ProfileMapper.mapPaymentToEntity(allPaymentResponse)
        }
    }

    fun get_create_payment(createPaymentRequest: PaymentRequest): Observable<Payment> {
        return profileWebServices.get_create_payment(createPaymentRequest)
            .mapObservable { createPaymentResponse ->
                ProfileMapper.mapPaymentToEntity(createPaymentResponse)
            }
    }

    fun get_all_payment_method(): Observable<PayMethod> {
        return profileWebServices.get_all_payment_method().mapObservable { allPaymentMethodResponse ->
            ProfileMapper.mapPayMethodToEntity(allPaymentMethodResponse)
        }
    }
}