package com.cendrawasih.nyopi.features.repository.payment

import com.cendrawasih.nyopi.data.entity.PayMethod
import com.cendrawasih.nyopi.data.entity.Payment
import com.cendrawasih.nyopi.data.event.MutableStateEventManager
import com.cendrawasih.nyopi.data.event.StateEventManager
import com.cendrawasih.nyopi.data.request.PaymentRequest
import com.cendrawasih.nyopi.util.fetchStateEventSubscriber
import io.reactivex.disposables.CompositeDisposable
import okhttp3.internal.closeQuietly

class PaymentRepositoryImpl(private val dataSource: PaymentDataSource) : PaymentRepository {

    private val disposables = CompositeDisposable()

    private var _currentPaymentStateEventManager: MutableStateEventManager<Payment> =
        MutableStateEventManager()
    override val currentPaymentStateEventManager: StateEventManager<Payment>
        get() = _currentPaymentStateEventManager

    private var _allPaymentStateEventManager: MutableStateEventManager<Payment> =
        MutableStateEventManager()
    override val allPaymentStateEventManager: StateEventManager<Payment>
        get() = _allPaymentStateEventManager

    private var _createPaymentStateEventManager: MutableStateEventManager<Payment> =
        MutableStateEventManager()
    override val createPaymentStateEventManager: StateEventManager<Payment>
        get() = _createPaymentStateEventManager

    private var _allPaymentMethodStateEventManager: MutableStateEventManager<PayMethod> =
        MutableStateEventManager()
    override val allPaymentMethodStateEventManager: StateEventManager<PayMethod>
        get() = _allPaymentMethodStateEventManager

    override fun get_current_payment(currentPaymentRequest: PaymentRequest) {
        val disposable = dataSource.get_current_payment(currentPaymentRequest)
            .fetchStateEventSubscriber { stateEvent ->
                _currentPaymentStateEventManager.post(stateEvent)
            }
        disposables.add(disposable)
    }

    override fun get_all_payment() {
        val disposable = dataSource.get_all_payment().fetchStateEventSubscriber { stateEvent ->
            _allPaymentStateEventManager.post(stateEvent)
        }
        disposables.add(disposable)
    }

    override fun get_create_payment(createPaymentRequest: PaymentRequest) {
        val disposable = dataSource.get_create_payment(createPaymentRequest)
            .fetchStateEventSubscriber { stateEvent ->
                _createPaymentStateEventManager.post(stateEvent)
            }
        disposables.add(disposable)
    }

    override fun get_all_payment_method() {
        val disposable =
            dataSource.get_all_payment_method().fetchStateEventSubscriber { stateEvent ->
                _allPaymentMethodStateEventManager.post(stateEvent)
            }
        disposables.add(disposable)
    }

    override fun close() {
        _currentPaymentStateEventManager.closeQuietly()
        _allPaymentStateEventManager.closeQuietly()
        _createPaymentStateEventManager.closeQuietly()
        _allPaymentMethodStateEventManager.closeQuietly()
    }

}