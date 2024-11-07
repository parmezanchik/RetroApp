package com.example.retroapp

import android.app.Application
import com.example.retroapp.di.appModule
import com.example.retroapp.di.databaseModule
import com.example.retroapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, networkModule, databaseModule)
        }
    }
}