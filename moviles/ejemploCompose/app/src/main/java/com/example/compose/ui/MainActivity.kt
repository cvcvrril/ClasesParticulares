package com.example.compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Box

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.compose.ui.ejemplo.PantallaEjemploScreen
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity es la actividad principal de la aplicación
 * Está anotada con @AndroidEntryPoint para permitir la inyección de dependencias con Hilt
 * **/

/**
 * Método al que se llama cuando la actividad se crea
 * **/

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               //PantallaEjemplo()
            PantallaEjemploScreen()
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

