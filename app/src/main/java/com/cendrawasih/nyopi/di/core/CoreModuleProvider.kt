package com.cendrawasih.nyopi.di.core

import org.koin.core.module.Module

object CoreModuleProvider {
    private val coreModuleContainer = CoreModuleContainer()

    fun coreModules(): List<Module> {
        return listOf(
            coreModuleContainer.webServicesModule
        )
    }
}