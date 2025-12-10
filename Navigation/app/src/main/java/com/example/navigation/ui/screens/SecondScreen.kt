package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, parameter: String?, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = "Parameter: $parameter"
        )
        Button(
            onClick = { navController.navigate("home") }
        ) {
            Text("Got to home")
        }
    }
}