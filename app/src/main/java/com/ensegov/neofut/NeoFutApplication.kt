package com.ensegov.neofut

import android.app.Application
import com.ensegov.neofut.di.dataModule
import com.ensegov.neofut.di.domainModule
import com.ensegov.neofut.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class NeoFutApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NeoFutApplication)
            modules(dataModule, domainModule, uiModule)
        }
    }
}