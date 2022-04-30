package com.cendrawasih.nyopi

import android.app.Application
import android.os.Build
import com.cendrawasih.nyopi.di.homepage.HomePageModuleContainer
import com.cendrawasih.profile.di.ProfileModuleContainer
import com.facebook.flipper.BuildConfig.DEBUG
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        flipperIntegration()
        val homePageModuleContainer = HomePageModuleContainer()
        val profileModuleContainer = ProfileModuleContainer()

        startKoin {
            androidContext(this@MyApp)
            modules(profileModuleContainer.modules() + homePageModuleContainer.modules())
        }
    }

    private fun flipperIntegration() {
        val isVersionAboveNougat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
        if (isVersionAboveNougat) {
            SoLoader.init(this, false)

            if (DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
                val client = AndroidFlipperClient.getInstance(this)
                    .apply {
                        val plugin =
                            InspectorFlipperPlugin(this@MyApp, DescriptorMapping.withDefaults())
                        addPlugin(plugin)
                    }
                client.start()
            }
        }
    }
}