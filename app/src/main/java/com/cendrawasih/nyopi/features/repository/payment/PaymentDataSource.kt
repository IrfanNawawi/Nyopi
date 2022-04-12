package com.cendrawasih.nyopi.features.repository.payment

import com.cendrawasih.nyopi.data.Mapper
import com.cendrawasih.nyopi.data.WebServices
import com.cendrawasih.nyopi.data.entity.PayMethod
import com.cendrawasih.nyopi.data.entity.Payment
import com.cendrawasih.nyopi.data.request.PaymentRequest
import com.cendrawasih.nyopi.util.mapObservable
import io.reactivex.Observable

class PaymentDataSource(private val webServices: WebServices) {
    fun get_current_payment(currentPaymentRequest: PaymentRequest): Observable<Payment> {
        return webServices.get_current_payment(currentPaymentRequest).mapObservable { currentPaymentResponse ->
            Mapper.mapPaymentToEntity(currentPaymentResponse)
        }
    }

    fun get_all_payment(): Observable<Payment> {
        return webServices.get_all_payment().mapObservable { allPaymentResponse ->
            Mapper.mapPaymentToEntity(allPaymentResponse)
        }
    }

    fun get_create_payment(createPaymentRequest: PaymentRequest): Observable<Payment> {
        return webServices.get_create_payment(createPaymentRequest)
            .mapObservable { createPaymentResponse ->
                Mapper.mapPaymentToEntity(createPaymentResponse)
            }
    }

    fun get_all_payment_method(): Observable<PayMethod> {
        return webServices.get_all_payment_method().mapObservable { allPaymentMethodResponse ->
            Mapper.mapPayMethodToEntity(allPaymentMethodResponse)
        }
    }
}