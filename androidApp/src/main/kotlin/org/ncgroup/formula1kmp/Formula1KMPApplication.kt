package org.ncgroup.formula1kmp

import AndroidAppComponent
import android.app.Application

class Formula1KMPApplication : Application() {

    val component: AndroidAppComponent by lazy {
        AndroidAppComponent.Companion::class
    }

    override fun onCreate() {
        super.onCreate()
    }

}