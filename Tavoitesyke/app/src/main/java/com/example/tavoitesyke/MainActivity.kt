package com.example.tavoitesyke

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
import com.example.tavoitesyke.ui.screens.HrLimits
import com.example.tavoitesyke.ui.theme.TavoitesykeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TavoitesykeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HrLimits(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

