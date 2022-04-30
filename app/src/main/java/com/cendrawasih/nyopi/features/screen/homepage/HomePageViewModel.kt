package com.cendrawasih.nyopi.features.screen.homepage

import androidx.lifecycle.ViewModel
import com.cendrawasih.core.event.StateEventManager
import com.cendrawasih.profile.data.entity.LoginRegister
import com.cendrawasih.profile.data.remote.request.LoginRegisterRequest
import com.cendrawasih.profile.data.repository.ProfileRepository
import okhttp3.internal.closeQuietly

class HomePageViewModel(private val repository: ProfileRepository) : ViewModel() {

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

    override fun onCleared() {
        super.onCleared()
        repository.close()
        userManager.closeQuietly()
    }
}