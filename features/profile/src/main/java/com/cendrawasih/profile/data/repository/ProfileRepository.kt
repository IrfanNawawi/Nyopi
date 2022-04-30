package com.cendrawasih.profile.data.repository

import com.cendrawasih.core.event.StateEventManager
import com.cendrawasih.profile.data.entity.LoginRegister
import com.cendrawasih.profile.data.entity.User
import com.cendrawasih.profile.data.remote.request.LoginRegisterRequest
import java.io.Closeable

// interface segregation
// implementasi api-impl
// api (interface) sebagai object
// impl sebagai implementasi dari api
interface ProfileRepository : Closeable {
    val loginRegisterStateEventManager: StateEventManager<LoginRegister>
    val userStateEventManager: StateEventManager<User>

    fun post_login(loginRequest: LoginRegisterRequest)
    fun post_register(registerRequest: LoginRegisterRequest)
    fun get_user()
}