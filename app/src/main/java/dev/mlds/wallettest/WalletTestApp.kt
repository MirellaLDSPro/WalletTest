package dev.mlds.wallettest

import android.app.Application
import dev.mlds.wallettest.data.di.dataModule
import dev.mlds.wallettest.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WalletTestApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WalletTestApp)
            // ToDo: Initialize modules
            modules(dataModule, domainModule)
        }
    }
}