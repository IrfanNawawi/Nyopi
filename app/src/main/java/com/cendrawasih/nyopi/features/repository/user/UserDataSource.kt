package com.cendrawasih.nyopi.features.repository.user

import com.cendrawasih.nyopi.data.Mapper
import com.cendrawasih.nyopi.data.WebServices
import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.entity.User
import com.cendrawasih.nyopi.data.request.LoginRegisterRequest
import com.cendrawasih.nyopi.util.mapObservable
import io.reactivex.Observable

class UserDataSource(private val webServices: WebServices) {
    fun login(loginRequest: LoginRegisterRequest): Observable<LoginRegister> {
        return webServices.post_login(loginRequest).mapObservable { loginRegisterResponse ->
            Mapper.mapLoginRegisterToEntity(loginRegisterResponse)
        }
    }

    fun register(registerRequest: LoginRegisterRequest): Observable<LoginRegister> {
        return webServices.post_register(registerRequest).mapObservable { loginRegisterResponse ->
            Mapper.mapLoginRegisterToEntity(loginRegisterResponse)
        }
    }

    fun getUser(): Observable<User> {
        return webServices.getUser().mapObservable { userResponse ->
            Mapper.mapUserResponseToEntity(userResponse)
        }
    }
}