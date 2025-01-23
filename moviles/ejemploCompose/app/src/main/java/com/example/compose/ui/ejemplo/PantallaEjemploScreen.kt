package com.example.compose.ui.ejemplo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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


    PantallaEjemploContent(
        id = uiState.id,
        sumarId = {pantallaEjemploViewModel.handleEvent(PantallaEjemploEvent.SumarId)}
    )

}

/**
 * Dentro de lo que establecemos como "el archivo que contiene las visuales de la pantalla" podemos
 *  crear más funciones que vayan albergando los distintos apartados de la pantalla
 *  Por ejemplo, en esta función montaremos el layout, dejando el estado en la función superior
 *  Los valores del estado se van pasando en los parámetros que pida la función (en este caso, id)
 * **/

@Composable
fun PantallaEjemploContent(

    id: Int,
    sumarId: (Int) -> Unit,

    ){

    Surface() {
        Box(){
            Column(

                /**
                 * Esto te permite colocar los elementos según lo prefieras más
                 * En la documentación oficial de Google te viene mejor explicado cada posición
                 *  y ejemplos de organización en las pantallas
                 * https://developer.android.com/develop/ui/compose/layouts/basics?hl=es-419
                 * **/

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text((id).toString())
                Button(onClick = {sumarId(id)}) {
                    Text("Sumar id")
                }
            }

        }
    }
}

/**
 * Estas son las @Preview
 * Te ayudan a visualizar la organización de la pantalla en diferentes escenarios (modo, colores,
 *  dispositivos, ...)
 *  NO se pueden pasar valores que cambién, tienes que estableces valores fijos en los campos
 * **/

@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.5f,
    name = "Light Mode"
)
@Composable
fun PreviewPantallaEjemplo(){
    PantallaEjemploContent(1) { }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.5f,
    name = "Light Mode",
    device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun PreviewLandPantallaEjemplo(){
    PantallaEjemploContent(1) { }
}