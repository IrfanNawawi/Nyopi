package com.cendrawasih.nyopi.di.homepage

import org.koin.core.module.Module

object HomePageModuleProvider {
    private val homePageModuleContainer = HomePageModuleContainer()

    // reflection
    fun homePageModules(): List<Module> {
        val declarHomePageModule = homePageModuleContainer::class.java.declaredFields.map {
            it.isAccessible = true
            it.get(homePageModuleContainer) as Module
        }
        return declarHomePageModule
    }
}