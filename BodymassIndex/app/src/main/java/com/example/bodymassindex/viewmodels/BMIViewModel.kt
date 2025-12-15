package com.example.bodymassindex.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private val height: Double
        get() = heightInput.toDoubleOrNull() ?: 0.0

    private val weight: Double
        get() = weightInput.toDoubleOrNull() ?: 0.0

    val bmi: Double
        get() = if (height > 0.0 && weight > 0.0) {
            weight / (height * height)
        } else 0.0
}
