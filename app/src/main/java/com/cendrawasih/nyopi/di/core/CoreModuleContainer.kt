package com.cendrawasih.nyopi.di.core

import com.cendrawasih.nyopi.data.WebServices
import org.koin.dsl.module

class CoreModuleContainer {
    val webServicesModule = module {
        single<WebServices> { WebServices.create() }
    }
}