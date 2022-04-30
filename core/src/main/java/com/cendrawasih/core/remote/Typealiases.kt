package com.cendrawasih.core.remote

import io.reactivex.Observable
import retrofit2.Response

typealias NyopiResponse<T> = Observable<Response<BaseResponse<T>>>