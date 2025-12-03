package com.example.alcometer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.alcometer.R

@Composable
fun GenderChoice(male: Boolean, setMale: (Boolean) -> Unit) {
    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = male,
                onClick = { setMale(true)}
            )
            Text(stringResource(R.string.male))
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !male,
                onClick = { setMale(false)}
            )
            Text("Female")
        }
    }
}

