package com.example.compose.ui.common


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.navigation.AppScreenDestination
import com.example.compose.ui.navigation.listaPantallas

/**
 * Es la función que se encarga de componer la barra inferior de navegación
 * Necesita el navController y las pantallas
 * **/


@Composable
fun BottomBar(
    navController: NavController,
    screens: List<AppScreenDestination>,
    ) {

    
    NavigationBar {
        val state = navController.currentBackStackEntryAsState()

        val currentDestination = state.value?.destination
        screens.forEach { screen ->
                NavigationBarItem(
                    icon = { Icon(screen.icon, contentDescription = null) } ,
                    label = { Text(screen.title) },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {

                        navController.navigate(screen.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )

        }
    }
}

/**
 * Preview de cómo se vería el bottomBar
 * **/

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    BottomBar(navController = navController, screens = listaPantallas)
}