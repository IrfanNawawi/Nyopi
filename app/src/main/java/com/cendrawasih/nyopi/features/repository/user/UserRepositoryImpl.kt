package com.cendrawasih.nyopi.features.repository.user

import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.entity.User
import com.cendrawasih.nyopi.data.event.MutableStateEventManager
import com.cendrawasih.nyopi.data.event.StateEventManager
import com.cendrawasih.nyopi.data.request.LoginRegisterRequest
import com.cendrawasih.nyopi.util.fetchStateEventSubscriber
import io.reactivex.disposables.CompositeDisposable
import okhttp3.internal.closeQuietly

class UserRepositoryImpl(private val dataSource: UserDataSource) : UserRepository {

    private val disposables = CompositeDisposable()

    // backing properties
    private var _loginRegisterStateEventManager: MutableStateEventManager<LoginRegister> =
        MutableStateEventManager()
    override val loginRegisterStateEventManager: StateEventManager<LoginRegister>
        get() = _loginRegisterStateEventManager

    private var _userStateEventManager: MutableStateEventManager<User> = MutableStateEventManager()
    override val userStateEventManager: StateEventManager<User>
        get() = _userStateEventManager

    override fun post_login(loginRequest: LoginRegisterRequest) {
        val disposable =
            dataSource.login(loginRequest).fetchStateEventSubscriber { stateEvent ->
                _loginRegisterStateEventManager.post(stateEvent)
            }

        disposables.add(disposable)
    }

    override fun post_register(registerRequest: LoginRegisterRequest) {
        val disposable =
            dataSource.register(registerRequest).fetchStateEventSubscriber { stateEvent ->
                _loginRegisterStateEventManager.post(stateEvent)
            }

        disposables.add(disposable)
    }

    override fun get_user() {
        val disposable = dataSource.getUser().fetchStateEventSubscriber { stateEvent ->
            _userStateEventManager.post(stateEvent)
        }

        disposables.add(disposable)
    }

    override fun close() {
        _userStateEventManager.closeQuietly()
        _loginRegisterStateEventManager.closeQuietly()
        disposables.dispose()
    }

}