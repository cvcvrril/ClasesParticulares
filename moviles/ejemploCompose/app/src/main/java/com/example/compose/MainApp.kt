package com.example.compose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Clase principal de la aplicación
 * Extendemos `Application` para realizar inicializaciones globales
 * Usamos `@HiltAndroidApp` para habilitar Hilt como el gestor de inyección de dependencias
 **/

@HiltAndroidApp
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

    }
}