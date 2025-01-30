package com.example.compose.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.common.BottomBar
import com.example.compose.ui.ejemplo.PantallaEjemploScreen
import com.example.compose.ui.ejemplo2.PantallaEjemplo2Screen

/**
 * En este archivo montamos toda la estructura de navegación entre las pantallas
 * **/

@Composable
fun Navigation(){

    /**
     * El navController se encarga de controlar la navegación
     * Es necesaria crearla para el correcto funcionamiento de la navegación por las pantallas
     * **/

    val navController = rememberNavController()

    /**
     * Importamos el Composable de la barrita de abajo y le pasamos el navController
     * **/

    val bottomBar : @Composable () -> Unit ={ BottomBar(
        navController = navController,
        screens = listaPantallas
    ) }

    /**
     * Metemos dentro del Scaffold el BottomBar y llamamos a un NavHost que se encargara de
     *  llamar a las funciones que manejan las pantallas cuando interactuemos con la barra de
     *  navegación
     * En el NavHost importamos el navController, la primera pantalla que se cargará, y un
     *  modifier que se encargará de establecer un tamaño fijo a la barra de navegación
     * **/

    Scaffold (
        bottomBar = bottomBar,
    ){ innerPadding ->

        NavHost(
            navController = navController,
            startDestination = SumarDestination,
            modifier = Modifier.padding(innerPadding)
        ) {

            /**
             * En cada composable se mete la dirección a la que debe de apuntar el Host, y la
             *  función que llama a la pantalla
             * **/

            composable<SumarDestination> {
                PantallaEjemploScreen()
            }
            composable<MultiplicarDestination> {
                PantallaEjemplo2Screen()
            }


        }
    }
}