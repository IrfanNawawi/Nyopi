package com.cendrawasih.nyopi.features.screen.homepage

import androidx.lifecycle.ViewModel
import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.event.StateEventManager
import com.cendrawasih.nyopi.data.request.LoginRegisterRequest
import com.cendrawasih.nyopi.features.repository.user.UserRepository

class HomePageViewModel(private val repository: UserRepository) : ViewModel() {

    val userManager: StateEventManager<LoginRegister> = repository.loginRegisterStateEventManager

    fun login(username: String, password: String) {
        val request = LoginRegisterRequest(username, password)
        repository.post_login(request)
    }

    fun register(username: String, password: String) {
        val request = LoginRegisterRequest(username, password)
        repository.post_register(request)
    }

    fun getUser() {
        repository.get_user()
    }
}