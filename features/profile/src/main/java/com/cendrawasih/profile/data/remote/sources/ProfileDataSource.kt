package com.cendrawasih.profile.data.remote.sources

import com.cendrawasih.core.util.mapObservable
import com.cendrawasih.profile.data.ProfileMapper
import com.cendrawasih.profile.data.entity.LoginRegister
import com.cendrawasih.profile.data.entity.User
import com.cendrawasih.profile.data.remote.ProfileWebServices
import com.cendrawasih.profile.data.remote.request.LoginRegisterRequest
import io.reactivex.Observable

class ProfileDataSource(private val profileWebServices: ProfileWebServices) {
    fun login(loginRequest: LoginRegisterRequest): Observable<LoginRegister> {
        return profileWebServices.post_login(loginRequest).mapObservable { loginRegisterResponse ->
            ProfileMapper.mapLoginRegisterToEntity(loginRegisterResponse)
        }
    }

    fun register(registerRequest: LoginRegisterRequest): Observable<LoginRegister> {
        return profileWebServices.post_register(registerRequest).mapObservable { loginRegisterResponse ->
            ProfileMapper.mapLoginRegisterToEntity(loginRegisterResponse)
        }
    }

    fun getUser(): Observable<User> {
        return profileWebServices.getUser().mapObservable { userResponse ->
            ProfileMapper.mapUserResponseToEntity(userResponse)
        }
    }
}