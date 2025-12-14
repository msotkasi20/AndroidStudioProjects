package com.example.mvvmcounterandlocation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvmcounterandlocation.viewmodels.CounterViewModel

@Composable
fun Screen1(viewModel: CounterViewModel, onNavigateToScreen2: () -> Unit, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ) {
        Text("Screen 1")
        Text("Count " + viewModel.count)
        Button(
            onClick={ viewModel.increment() }
        ) {
            Text("Add")
        }
        Button(
            onClick = onNavigateToScreen2
        ) {
            Text("Go to screen 2")
        }
    }
}