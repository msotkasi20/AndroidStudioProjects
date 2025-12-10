package com.example.bottomnavigation.ui.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.wear.compose.navigation.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    val tabs = listOf(
        TabItem("Home", Icons.Filled.Home, route = "main"),
        TabItem("Info", Icons.Filled.Info, route = "info"),
        TabItem("Favorite", Icons.Filled.Favorite, route = "favorite")
    )

    NavigationBar {
        tabs.forEach { tab ->
            val selected = tab.route === backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(tab.route)},
                label = { Text( text = tab.label) },
                icon = { Icon(
                    imageVector = tab.icon,
                    contentDescription = tab.label
                ) }
            )
        }
    }
}