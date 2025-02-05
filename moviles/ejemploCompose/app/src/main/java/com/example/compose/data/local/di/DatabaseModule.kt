package com.example.compose.data.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.compose.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences
import javax.inject.Singleton
//import androidx.datastore.core.DataStore

/**
 * Clase que se encarga de inicializar la base de datos local (Room)
 * **/

/**
 * Aquí tienes documentación oficial de Google sobre Room:
 * -> https://developer.android.com/training/data-storage/room?hl=es-419
 * -> https://developer.android.com/jetpack/androidx/releases/room?hl=es-419
 * **/


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db")
            .createFromAsset("database/alumnos.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Información sobre el data store:
     * -> https://developer.android.com/jetpack/androidx/releases/datastore?hl=es-419
     * **/

    val Context.dataStore by preferencesDataStore(name = "data_store")

}

