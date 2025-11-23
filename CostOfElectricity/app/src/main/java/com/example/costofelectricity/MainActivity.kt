package com.example.costofelectricity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.costofelectricity.ui.theme.CostOfElectricityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CostOfElectricityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyCost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyCost(modifier: Modifier = Modifier) {
    var consumptionText by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableStateOf(0.05f) }
    var lowerVat by remember { mutableStateOf(false) }

    val consumption = consumptionText.toDoubleOrNull() ?: 0.0
    val vatRate = if (lowerVat) 0.10 else 0.24
    val costWithVat = consumption * sliderPosition * (1 + vatRate)

    Column (
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text (
            text = "Cost of electricity",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = consumptionText,
            onValueChange = { consumptionText = it },
            label = { Text("Consumption in kWh")}, //tällä saadaan näkymään teksti inputin yläreunassa arvoa syötettäessä
            singleLine = true,   //boolean, yksi rivinen input
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // numeronäppäimistö
        )
        Text (
            text = "Price/kWh: ${"%.2f".format(sliderPosition)} €/kWh ",
        )
        Slider (
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0.05f..0.5f
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = lowerVat,
                onCheckedChange = { lowerVat = it }
            )
            Text (
                text = "VAT 10%"
            )
        }
        Surface (
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.primary
        ) {
            Text (
                text = "${"%.2f".format(costWithVat)} €",
                modifier = Modifier
                    .padding(15.dp)
            )
        }
    }
}
