package com.example.compose.ui.ejemplo

import androidx.lifecycle.ViewModel
import com.example.primerxmlmvvm.common.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Ponemos esta anotación para indicarle al Hilt que esta clase es el ViewModel
 * Sino, no tira
 * **/


@HiltViewModel
class PantallaEjemploViewModel @Inject constructor(
    private val stringProvider: StringProvider
): ViewModel(){

    /**
     * Estado público y no mutable que expone el estado actual de la pantalla
     * Se utiliza un `StateFlow` para garantizar la observación reactiva de los datos
     */

    private val _uiState = MutableStateFlow(PantallaEjemploState(0))
    val uiState: StateFlow<PantallaEjemploState> get() = _uiState

    /**
     * Método para manejar eventos de la pantalla
     * Aquí puedes definir la lógica que se ejecutará en respuesta a los eventos recibidos
     */

    fun handleEvent(event: PantallaEjemploEvent){
        when(event){


            else -> {}
        }

    }

}