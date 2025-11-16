package com.example.currencydemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencydemo.ui.theme.CurrencyDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CurrencyScreen( modifier: Modifier = Modifier) {
    var sek by remember { mutableStateOf("") }
    val sekAsNumber = sek.toDoubleOrNull() ?: 0.0
    val euros = sekAsNumber * 0.091
    val formattedEuros = String.format(stringResource(R.string._2f), euros)

    val fieldModifier = Modifier.fillMaxWidth()

    Column (
        modifier = modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Text(
            text = stringResource(R.string.currency_screen),
            modifier = fieldModifier,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Text(
            text= stringResource(R.string.sek),
            modifier = fieldModifier
        )
        TextField(
            value = sek,
            onValueChange = { sek = it },
            modifier = fieldModifier
        )
        Text(
            text = stringResource(R.string.eur),
            modifier = fieldModifier
        )
        Text(
            text = formattedEuros,
            modifier = fieldModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyScreenPreview() {
    CurrencyDemoTheme {
        CurrencyScreen()
    }
}