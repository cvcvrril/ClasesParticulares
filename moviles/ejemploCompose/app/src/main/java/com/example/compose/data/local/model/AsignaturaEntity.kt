package com.example.compose.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.compose.domain.model.Asignatura

@Entity(tableName = "asignaturas")
data class AsignaturaEntity(

    @PrimaryKey
    val cod_asignatura:Int,
    val titulo: String,
    val horas: Int,

)

fun AsignaturaEntity.toAsignatura(): Asignatura = Asignatura(
    cod_asignatura = this.cod_asignatura,
    titulo = this.titulo,
    horas = this.horas
)

fun Asignatura.toAsignaturaEntity(): AsignaturaEntity = AsignaturaEntity(
    cod_asignatura = this.cod_asignatura,
    titulo = this.titulo,
    horas = this.horas
)