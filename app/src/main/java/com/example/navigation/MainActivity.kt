package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.screens.HomeScreen
import com.example.navigation.ui.screens.SecondScreen
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationExampleApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationExampleApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(navController, modifier)
        }
        composable(route = "second/{parameter}",
            arguments = listOf(
                navArgument("parameter") {
                    type = NavType.StringType
                }
            )
        ) {
            SecondScreen(navController, it.arguments?.getString("parameter"), modifier)
        }
    }
}