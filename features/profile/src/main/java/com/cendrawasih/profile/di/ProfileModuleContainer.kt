package com.cendrawasih.profile.di

import com.cendrawasih.core.di.ModuleContainer
import com.cendrawasih.core.remote.RetrofitProvider
import com.cendrawasih.profile.data.remote.ProfileWebServices
import com.cendrawasih.profile.data.remote.sources.ProfileDataSource
import com.cendrawasih.profile.data.repository.ProfileRepository
import com.cendrawasih.profile.data.repository.ProfileRepositoryImpl
import org.koin.dsl.module

class ProfileModuleContainer : ModuleContainer(){

    private val webServiceModule = module {
        single<ProfileWebServices> { RetrofitProvider.retrofit().create(ProfileWebServices::class.java) }
    }

    private val dataSourceModule = module {
        single<ProfileDataSource> { ProfileDataSource(get()) }
    }

    private val repositoryModule = module {
        single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    }
}