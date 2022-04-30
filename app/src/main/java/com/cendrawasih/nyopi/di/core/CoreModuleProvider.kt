package com.cendrawasih.nyopi.di.core

import org.koin.core.module.Module

object CoreModuleProvider {
    private val coreModuleContainer = CoreModuleContainer()

    // reflection
    fun coreModules(): List<Module> {
        val declarCoreModule = coreModuleContainer::class.java.declaredFields.map {
            it.isAccessible = true
            it.get(coreModuleContainer) as Module
        }

        return declarCoreModule
    }
}