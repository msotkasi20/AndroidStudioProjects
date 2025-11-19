package com.example.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temperatureconverter.ui.theme.TemperatureConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemperatureConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Converter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Converter(modifier: Modifier = Modifier) {
    var temperature: String by remember { mutableStateOf("") }
    var fahrenheitSelected: Boolean by remember { mutableStateOf(true)}
    val temperatureFloat: Float? = temperature.toFloatOrNull()

    val result = when (fahrenheitSelected) {
        true -> if (temperatureFloat !== null) (temperatureFloat - 32) * 5/9 else 0f
        false -> if (temperatureFloat !== null) (temperatureFloat * 9/5) + 32 else 0f
    }

    Column(
        modifier = modifier.padding(all = 8.dp)
    ) {
        Text(
            text = "Temperature Converter",
            modifier = Modifier.padding(bottom = 16.dp),
            fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = temperature,
            onValueChange = {temperature = it},
            label = {
                Text("Enter temperature")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = fahrenheitSelected,
                onClick = {fahrenheitSelected = true},
            )
            Text("Fahrenheit to Celsius")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !fahrenheitSelected,
                onClick = {fahrenheitSelected = false},
            )
            Text("Celsius to Fahrenheit")
        }
        Text(text = result.toString())
    }
}

@Composable
fun OutLinedTextField(label: @Composable () -> Unit, onValueChange: () -> Unit, value: String) {
    TODO("Not yet implemented")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TemperatureConverterTheme {
        Greeting("Android")
    }
}