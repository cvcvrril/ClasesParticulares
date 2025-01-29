package com.example.compose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Debemos de guardar una lista de las pantallas por las que queremos navegar en la barra de navegación
 * **/

val listaPantallas = listOf(PantallaSumar, PantallaMultiplicar)

/**
 * Creamos una interfaz para hacer más sencilla la tarea de indicar los destinos de las pantallas
 * **/

interface AppScreenDestination {
    val route: Any
    val title: String
    val onBottomBar: Boolean
    val icon: ImageVector
    val scaffoldState: ScaffoldState
        get() = ScaffoldState()

}

/**
 * A partir de aquí montamos objetos que hereden de la interfaz anterior
 * **/

object PantallaSumar : AppScreenDestination{
    override val route = SumarDestination
    override val title = "Sumar"
    override val onBottomBar = true
    override val icon = Icons.Filled.Favorite
}

object PantallaMultiplicar : AppScreenDestination{
    override val route = MultiplicarDestination
    override val title = "Multiplicar"
    override val onBottomBar: Boolean = true
    override val icon = Icons.Filled.Favorite

}