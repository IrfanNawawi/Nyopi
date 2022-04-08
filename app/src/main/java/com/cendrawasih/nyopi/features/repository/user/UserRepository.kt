package com.cendrawasih.nyopi.features.repository.user

import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.entity.User
import com.cendrawasih.nyopi.data.event.StateEventManager
import java.io.Closeable

// interface segregation
// implementasi api-impl
// api (interface) sebagai object
// impl sebagai implementasi dari api
interface UserRepository : Closeable {
    val loginRegisterStateEventManager: StateEventManager<LoginRegister>
    val userStateEventManager: StateEventManager<User>

    fun login(username: String, password: String)
    fun register(username: String, password: String)
    fun getUser()
}