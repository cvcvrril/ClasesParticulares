package com.example.compose

import com.example.compose.ui.ejemplo.PantallaEjemploEvent
import com.example.compose.ui.ejemplo.PantallaEjemploViewModel
import com.example.primerxmlmvvm.common.StringProvider
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock

class TestPantallaEjemploViewModel {

    //@Mock
    private lateinit var viewModel: PantallaEjemploViewModel
    private val stringProvider: StringProvider = mock(StringProvider::class.java)

    @Before
    fun setup() {
        viewModel = PantallaEjemploViewModel(stringProvider)
    }

    @Test
    fun `test initial state`() = runTest {
        val state = viewModel.uiState.first()
        assertEquals(0, state.id)
    }

    @Test
    fun `test sumarId event`() = runTest {
        viewModel.handleEvent(PantallaEjemploEvent.SumarId)
        val state = viewModel.uiState.first()
        assertEquals(1, state.id)
    }

    @Test
    fun `test cambiarId event`() = runTest {
        viewModel.handleEvent(PantallaEjemploEvent.CambiarId(5))
        val state = viewModel.uiState.first()
        assertEquals(5, state.id)
    }

}