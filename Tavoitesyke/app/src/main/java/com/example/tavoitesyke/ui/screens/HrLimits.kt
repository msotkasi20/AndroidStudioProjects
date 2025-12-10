package com.example.tavoitesyke.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tavoitesyke.R
import com.example.tavoitesyke.viewmodels.HrViewModel

@Composable
fun HrLimits(modifier: Modifier = Modifier, hrViewModel: HrViewModel = viewModel()) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text (
            text = stringResource(R.string.heart_rate_limits),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            value = hrViewModel.ageInput,
            onValueChange = { hrViewModel.ageInput = it },
            singleLine = true,
            label = { Text(stringResource(R.string.age))},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text( text = stringResource(R.string.result_is_s_s, hrViewModel.lower, hrViewModel.upper))
    }
}