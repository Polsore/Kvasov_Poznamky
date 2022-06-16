package com.example.kvasov_poznamky

import android.app.Application
import timber.log.Timber

class PoznamkyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}