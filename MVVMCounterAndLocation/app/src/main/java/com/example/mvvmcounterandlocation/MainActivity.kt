package com.example.mvvmcounterandlocation

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmcounterandlocation.ui.screens.Screen1
import com.example.mvvmcounterandlocation.ui.screens.Screen2
import com.example.mvvmcounterandlocation.ui.theme.MVVMCounterAndLocationTheme
import com.example.mvvmcounterandlocation.viewmodels.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCounterAndLocationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val viewModel: CounterViewModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = "screen1",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("screen1") {
                            Screen1(
                                viewModel = viewModel,
                                onNavigateToScreen2 = {
                                    navController.navigate("screen2")
                                }
                            )
                        }
                        composable("screen2") {
                            Screen2(
                                viewModel = viewModel,
                                onNavigateToScreen1 = {
                                    navController.navigate("screen1")
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}
