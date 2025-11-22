package com.example.modifierdemo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.modifierdemo.ui.components.MyText

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val reusableModifier: Modifier = Modifier.padding(8.dp).background(Color.Red)
    Column(
        modifier = modifier
    ) {
        MyText("First text", modifier = reusableModifier)
        MyText("Second text")
        MyText("Third text", Modifier.fillMaxWidth().background(Color.Blue))
        MyText("Fourth text", reusableModifier.fillMaxWidth())
    }
}