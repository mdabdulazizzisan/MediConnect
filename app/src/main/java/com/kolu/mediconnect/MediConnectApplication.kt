package com.kolu.mediconnect

import android.app.Application
import com.kolu.mediconnect.di.appModule
import com.kolu.mediconnect.presentation.screens.auth.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MediConnectApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MediConnectApplication)
            modules(
                appModule,
                authModule
            )
        }
    }
}