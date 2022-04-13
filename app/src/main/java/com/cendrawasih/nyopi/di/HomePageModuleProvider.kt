package com.cendrawasih.nyopi.di

import org.koin.core.module.Module

object HomePageModuleProvider {
    private val homePageModuleContainer = HomePageModuleContainer()

    fun homePageModules(): List<Module> {
        return listOf(
            homePageModuleContainer.dataSourceModule,
            homePageModuleContainer.repositoryModule,
            homePageModuleContainer.viewModelMmodule
        )
    }
}