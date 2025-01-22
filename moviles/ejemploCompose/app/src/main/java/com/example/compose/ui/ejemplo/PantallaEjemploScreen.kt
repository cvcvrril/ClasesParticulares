package com.example.compose.ui.ejemplo

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PantallaEjemploScreen(

    pantallaEjemploViewModel: PantallaEjemploViewModel = hiltViewModel()

) {

    /**
     * Esto es para sacar el estado actual de la página
     * collectAsStateWithLifecycle: Convierte un flujo (Flow) en un estado observable compatible
     * con el ciclo de vida. Esto asegura que los datos reaccionen solo cuando la pantalla
     * está activa
     * **/

    val uiState by pantallaEjemploViewModel.uiState.collectAsStateWithLifecycle()

    Surface() {
        Box(){
            //Text("Hola")
            Text((uiState.id).toString())
        }
    }

}