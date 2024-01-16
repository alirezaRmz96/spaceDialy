package com.example.spacedaily.ui

import android.app.Application
import com.example.spacedaily.di.networkModule
import com.example.spacedaily.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SpaceDailyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SpaceDailyApp)
            modules(listOf(networkModule,viewModelModule))
        }
    }

}