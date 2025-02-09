package com.example.compose.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.compose.domain.model.Alumno

/**
 * Este es el objeto-entidad de Room
 * Será el que defina las tablas de la base de datos
 * **/

@Entity(tableName = "alumnos")
data class AlumnoEntity(

    @PrimaryKey
    val id: Int,
    val nombre: String,
    val apellido: String,
//    val asignaturas: List<AsignaturaEntity>
)

/**
 * Aquí montamos las funciones que se encargan de castear del objeto a la entidad (y viceversa)
 * **/

fun AlumnoEntity.toAlumno(): Alumno = Alumno(
    id = this.id,
    nombre = this.nombre,
    apellido = this.apellido,
//    asignaturas = this.asignaturas.map { it.toAsignatura() }
)

fun Alumno.toAlumnoEntity(): AlumnoEntity = AlumnoEntity(
    id = this.id,
    nombre = this.nombre,
    apellido = this.apellido,
//    asignaturas = this.asignaturas.map { it.toAsignaturaEntity() }
)
