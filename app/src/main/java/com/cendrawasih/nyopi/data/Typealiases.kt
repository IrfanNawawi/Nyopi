package com.cendrawasih.nyopi.data

import com.cendrawasih.nyopi.data.response.BaseResponse
import io.reactivex.Observable
import retrofit2.Response

typealias NyopiResponse<T> = Observable<Response<BaseResponse<T>>>