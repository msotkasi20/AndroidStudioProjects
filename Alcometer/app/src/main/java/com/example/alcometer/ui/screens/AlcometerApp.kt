package com.example.alcometer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import com.example.alcometer.ui.components.DropDownList
import com.example.alcometer.ui.components.GenderChoice
import com.example.alcometer.ui.components.Heading
import com.example.alcometer.ui.components.NumericField

@Composable
fun AlcometerApp(modifier: Modifier = Modifier) {

    var weight by remember { mutableStateOf("")}
    var male by remember { mutableStateOf(true)}
    var bottles by remember { mutableIntStateOf(1)}
    var hours by remember { mutableStateOf(1) }
    var result by remember { mutableFloatStateOf(0f)}


    var formModifier: Modifier = Modifier.fillMaxWidth()

    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(8.dp)
    ){
        Heading(formModifier,"Alcometer")
        NumericField( label = "Enter Weight", weight ) {
            weight = it
        }
        GenderChoice(male) {
            male = it
        }
        DropDownList( label= "Bottles", bottles ) {
            bottles = it
        }
        DropDownList( label= "Hours", hours ) {
            hours = it
        }
        Button(
            onClick = {
                val weightAsFloat = weight.toFloatOrNull() ?: 0f
                if (weightAsFloat > 0) {
                    val litres = bottles * 0.33f
                    val grams = litres * 8 * 4.5f
                    val burning = weightAsFloat / 10
                    val left = grams - ( burning * hours )

                    result = if (male) {
                        left / (weightAsFloat * 0.7f)
                    } else {
                        left / (weightAsFloat * 0.6f)
                    }
                }
            },
            modifier = formModifier
        ) {
            Text("Calculate")
        }
        Text ( text = "Result: %.2f".format( result ))
    }
}