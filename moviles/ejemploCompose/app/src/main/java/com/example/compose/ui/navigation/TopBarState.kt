package com.example.compose.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

/**
 * Archivo que contiene todo lo relacionado a la barra de navegación
 * **/


data class ScaffoldState(
    val topBarState: TopBarState = TopBarState(),
    val fabVisible : Boolean = false,
)

data class TopBarState(
    val arrangement: Arrangement.Horizontal = Arrangement.Center,
    val actions : @Composable RowScope.() -> Unit = {},
    val showNavigationIcon : Boolean = true,
    )