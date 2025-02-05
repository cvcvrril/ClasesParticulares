package com.example.compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compose.data.local.model.AlumnoEntity

/**
 *
 * **/

@Database(entities = [AlumnoEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
    abstract fun alumnoDao(): AlumnoDao
}