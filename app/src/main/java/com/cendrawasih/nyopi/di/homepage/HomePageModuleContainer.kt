package com.cendrawasih.nyopi.di.homepage

import com.cendrawasih.core.di.ModuleContainer
import com.cendrawasih.nyopi.features.screen.homepage.HomePageViewModel
import com.cendrawasih.nyopi.features.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class HomePageModuleContainer: ModuleContainer() {

    private val viewModelMmodule = module {
        viewModel { HomePageViewModel(get()) }
        viewModel { SplashViewModel(get()) }
    }
}