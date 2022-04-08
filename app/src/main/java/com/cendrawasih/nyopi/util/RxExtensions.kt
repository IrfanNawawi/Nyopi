package com.cendrawasih.nyopi.util

import com.cendrawasih.nyopi.data.NyopiResponse
import com.cendrawasih.nyopi.data.event.StateEvent
import com.cendrawasih.nyopi.data.response.BaseResponse
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

// interactor mapper
// original -> Observable<Response<BaseResponse<T>>>
// use higher order function for mapper data from response to entity
fun <T : Any, U : Any> NyopiResponse<T>.mapObservable(mapper: (T) -> U): Observable<U> {
    return flatMap { response ->
        if (response.isSuccessful) {
            val body = response.body()
            val data = body?.data
            if (data != null) {
                val dataMapper = mapper.invoke(data)
                Observable.just(dataMapper)
            } else {
                val exception = Throwable("Response data is null, message: ${body?.message}")
                Observable.error(exception)
            }
        } else {
            val bodyError = response.errorBody()?.string()
            val gson = GsonBuilder()
                .setPrettyPrinting()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

            val typeToken = object : TypeToken<BaseResponse<Any>>() {}.type
            val bodyErrorData = gson.fromJson<BaseResponse<Any>>(bodyError, typeToken)
            println("base response data -> $bodyErrorData")
            val messageResponse = bodyErrorData.message
            val messageHttp = response.message()
            val message = "$messageHttp, message: $messageResponse"
            val exception = Throwable(message)
            Observable.error(exception)
        }
    }
}

// fetcher state event
// merubah data observable entity ke dalam subscriber state event
fun <T : Any> Observable<T>.fetchStateEventSubscriber(onSubscribe: (StateEvent<T>) -> Unit): Disposable {
    return subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe {
            val eventLoading = StateEvent.Loading<T>()
            onSubscribe.invoke(eventLoading)
        }
        .subscribe({ data ->
            val eventSuccess = StateEvent.Success<T>(data)
            onSubscribe.invoke(eventSuccess)
        }, { throwable ->
            val eventFailure = StateEvent.Failure<T>(throwable)
            onSubscribe.invoke(eventFailure)
        })
}