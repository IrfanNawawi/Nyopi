package com.cendrawasih.nyopi.features.repository.user

import com.cendrawasih.nyopi.data.Mapper
import com.cendrawasih.nyopi.data.WebServices
import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.entity.User
import com.cendrawasih.nyopi.util.mapObservable
import io.reactivex.Observable

class UserDataSource(private val webServices: WebServices) {
    fun login(username: String, password: String): Observable<LoginRegister> {
        val params = HashMap<String, String>()
        params["username"] = username
        params["password"] = password

        return webServices.login(params).mapObservable { loginRegisterResponse ->
            Mapper.mapLoginRegisterToEntity(loginRegisterResponse)
        }
    }

    fun register(username: String, password: String): Observable<LoginRegister> {
        val params = HashMap<String, String>()
        params["username"] = username
        params["password"] = password

        return webServices.register(params).mapObservable { loginRegisterResponse ->
            Mapper.mapLoginRegisterToEntity(loginRegisterResponse)
        }
    }

    fun getUser(): Observable<User> {
        return webServices.getUser().mapObservable { userResponse ->
            Mapper.mapUserResponseToEntity(userResponse)
        }
    }
}