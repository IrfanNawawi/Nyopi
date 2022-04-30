package com.cendrawasih.core.event

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

// liskov substitution
// class ini dapat membuat 2 tipe object (StateEventManager abstract dan MutableStateEventManager abstract implimentation)

class MutableStateEventManager<T : Any> : StateEventManager<T>() {
    private val disposables = CompositeDisposable()

    override val stateEventSubject: PublishSubject<StateEvent<T>> = PublishSubject.create()

    override var onLoading: () -> Unit = {}
    override var onSuccess: (data: T) -> Unit = {}
    override var onFailure: (exception: Throwable) -> Unit = {}

    init {
        val disposable = stateEventSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { stateEvent ->
                when (stateEvent) {
                    is StateEvent.Loading -> onLoading.invoke()
                    is StateEvent.Success -> onSuccess.invoke(stateEvent.data)
                    is StateEvent.Failure -> onFailure.invoke(stateEvent.exception)
                }
            }

        disposables.add(disposable)
    }

    fun post(stateEvent: StateEvent<T>) {
        stateEventSubject.onNext(stateEvent)
    }

    override fun close() {
        disposables.dispose()
    }
}