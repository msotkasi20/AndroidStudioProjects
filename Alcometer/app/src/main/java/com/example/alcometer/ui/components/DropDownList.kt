package com.example.alcometer.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownList(label: String, initialValue: Int, onClick: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false)}

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {expanded = it}
    ) {
        OutlinedTextField(
            readOnly = true,
            label = {Text(label) },
            value = initialValue.toString(),
            onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable, enabled = true),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            /*colors = ExposedDropdownMenuDefaults.textFieldColors()*/
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {
            for (i in 0..24) {
                DropdownMenuItem(
                    text = {Text(i.toString()) },
                    onClick = {
                        onClick(i)
                        expanded = false
                    }
                )
            }
        }
    }
}