package com.example.compose.ui.ejemplo

import androidx.lifecycle.ViewModel
import com.example.primerxmlmvvm.common.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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


            /**
             * Si vas a tener un campo que va a cambiar de valor, te va a tocar montar que el estado
             *  de la pantalla se actualice
             * Esto se hace de forma automática en XML, pero en Compose hace falta hacerlo de
             *  forma manual
             * **/

            is PantallaEjemploEvent.CambiarId -> _uiState.update { it.copy(id = event.id) }
            is PantallaEjemploEvent.SumarId -> sumarId()
        }

    }

    /**
     * Esto es un ejemplo de una pequeña función que se llama desde el handleEvent
     * Realmente esta lógica no requiere que se separe (porque se puede hacer desde el handleEvent
     *  pero es para que lo veas mejor)
     * En la siguiente clase te enseño a montar un método que pase parámetros
     * **/

    private fun sumarId(){
        _uiState.update { it.copy(id = it.id + 1) }
    }

}