package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.ui.appbars.BottomBar
import com.example.bottomnavigation.ui.appbars.TopBar
import com.example.bottomnavigation.ui.screens.Favorite
import com.example.bottomnavigation.ui.screens.Info
import com.example.bottomnavigation.ui.screens.Main
import com.example.bottomnavigation.ui.theme.BottomnavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomnavigationTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() },
                    bottomBar = { BottomBar( navController) }
                ) { innerPadding ->
                   val modifier = Modifier.padding(innerPadding)
                    NavHost (
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable(route = "main") {
                            Main(modifier)
                        }
                        composable(route = "info") {
                            Info(modifier)
                        }
                        composable(route = "favorite") {
                            Favorite(modifier)
                        }
                    }
                }
            }
        }
    }
}
