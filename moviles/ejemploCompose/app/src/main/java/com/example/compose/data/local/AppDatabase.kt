package com.example.compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compose.data.local.model.AlumnoEntity

/**
 * Desde aquí enlazamos lo que es la clase que maneja el Room con los Daos que tengamos en
 *  el proyecto
 * **/

@Database(entities = [AlumnoEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
    abstract fun alumnoDao(): AlumnoDao
}