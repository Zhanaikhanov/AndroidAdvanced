package com.ankit.trendinggit

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TrendingGitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@TrendingGitApp)
            modules(appModule)
        }
        instance = this
    }

    companion object {
        lateinit var instance: TrendingGitApp
    }
}