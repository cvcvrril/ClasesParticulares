package com.example.compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Box

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.compose.ui.ejemplo.PantallaEjemploScreen
import com.example.compose.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity es la actividad principal de la aplicación
 * Está anotada con @AndroidEntryPoint para permitir la inyección de dependencias con Hilt
 * **/

/**
 * Método al que se llama cuando la actividad se crea
 * **/

/**
 * A partir de que metamos la navegación ya no tendremos que llamar a la función que contenga la pantalla,
 *  sino a la que se encarga de llevar la navegación (porque por defecto en ella se indica desde qué
 *  pantalla se va a inicializar la aplicación).
 * **/

/**
 * A medida que vayas actualizando y avanzando con la aplicación móvil, irás actualizando lo que contenga
 *  el MainActivity.
 * **/

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
               //PantallaEjemplo()
               //PantallaEjemploScreen()
            Navigation()
        }
    }
}

/**
 * Ejemplo de que podemos crear una función @Composable en el propio MainActivity que podría
 *  funcionar como la pantalla
 * Pero por motivos del modelo, las pantallas se crean a parte para mayor orden y limpieza
 *  del código
 **/

@Composable
fun PantallaEjemplo(){
    Surface() {
        Box(){
            Text("Hola")
        }
    }
}

