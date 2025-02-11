package com.example.compose.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.compose.domain.model.Asignatura
import com.example.compose.domain.model.Profesor

@Entity(tableName = "profesores")
data class ProfesorEntity (

    @PrimaryKey
    val id: Int,
    val nombre: String,
    val asignatura: Asignatura
)

fun ProfesorEntity.toProfesor(): ProfesorEntity = ProfesorEntity(
    id= this.id,
    nombre = this.nombre,
    asignatura = this.asignatura

)

fun Profesor.toProfesorEntity(): Profesor = Profesor(
    id= this.id,
    nombre = this.nombre,
    asignatura = this.asignatura
)