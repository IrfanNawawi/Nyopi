package com.cendrawasih.core.di

import org.koin.core.module.Module

abstract class ModuleContainer {

    // Provides List Modules
    fun modules(): List<Module>{
        val declarCoreModule = this::class.java.declaredFields.map {
            it.isAccessible = true
            it.get(this) as Module
        }

        return declarCoreModule
    }
}