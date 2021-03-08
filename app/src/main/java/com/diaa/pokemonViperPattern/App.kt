package com.diaa.pokemonViperPattern

import android.app.Application
import android.content.Context
import android.content.Intent
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var INSTANCE: App
    }

    init {
        INSTANCE = this
    }

    // Routing layer (VIPER)
    lateinit var cicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        this.initCicerone()
    }

    fun navigation(activityTo: Context, activityFrom: Class<*>?) {
        startActivity(Intent(activityTo, activityFrom))
    }

    private fun App.initCicerone() {
        this.cicerone = Cicerone.create()
    }


}