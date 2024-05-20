package com.dorysparadise.utilities

import android.annotation.SuppressLint
import android.app.Application

// Instanciar las preferencias al iniciar la app
class UtilityApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var shareSharedPrefs: SharedPrefs
    }
    override fun onCreate() {
        super.onCreate()
        shareSharedPrefs = SharedPrefs(applicationContext)
    }
}