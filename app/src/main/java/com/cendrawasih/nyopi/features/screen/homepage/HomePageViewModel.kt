package com.cendrawasih.nyopi.features.screen.homepage

import androidx.lifecycle.ViewModel
import com.cendrawasih.nyopi.data.WebServices
import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.event.StateEventManager
import com.cendrawasih.nyopi.data.request.LoginRegisterRequest
import com.cendrawasih.nyopi.features.repository.user.UserDataSource
import com.cendrawasih.nyopi.features.repository.user.UserRepository
import com.cendrawasih.nyopi.features.repository.user.UserRepositoryImpl

class HomePageViewModel : ViewModel() {
    private val services = WebServices.create()
    private val dataSource = UserDataSource(services)
    private val repository: UserRepository = UserRepositoryImpl(dataSource)

    val userManager: StateEventManager<LoginRegister> = repository.loginRegisterStateEventManager

    fun login(username: String, password: String) {
        val request = LoginRegisterRequest(username, password)
        repository.login(request)
    }

    fun register(username: String, password: String) {
        val request = LoginRegisterRequest(username, password)
        repository.register(request)
    }

    fun getUser() {
        repository.getUser()
    }
}