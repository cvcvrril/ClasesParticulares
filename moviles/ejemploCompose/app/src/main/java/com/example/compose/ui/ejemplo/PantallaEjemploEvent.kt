package com.example.compose.ui.ejemplo

/**
 * Clase que representa eventos que pueden ocurrir en la pantalla
 * **/

sealed class PantallaEjemploEvent {

    data object  SumarId : PantallaEjemploEvent()
    class CambiarId(val id: Int) : PantallaEjemploEvent()

}