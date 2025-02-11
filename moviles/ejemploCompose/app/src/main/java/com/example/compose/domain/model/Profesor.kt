package com.example.compose.domain.model

data class Profesor (
    val id: Int,
    val nombre: String,
    val asignatura: Asignatura
)