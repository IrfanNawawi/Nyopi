package com.cendrawasih.nyopi.di.homepage

import com.cendrawasih.nyopi.features.repository.user.UserDataSource
import com.cendrawasih.nyopi.features.repository.user.UserRepository
import com.cendrawasih.nyopi.features.repository.user.UserRepositoryImpl
import com.cendrawasih.nyopi.features.screen.homepage.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class HomePageModuleContainer {

    val dataSourceModule = module {
        single<UserDataSource> { UserDataSource(get()) }
    }

    val repositoryModule = module {
        single<UserRepository> { UserRepositoryImpl(get()) }
    }

    val viewModelMmodule = module {
        viewModel { HomePageViewModel(get()) }
    }
}