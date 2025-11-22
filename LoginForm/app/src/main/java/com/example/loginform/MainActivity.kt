package com.example.loginform

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyLogin(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyLogin(modifier: Modifier = Modifier) {
    var usernameField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("")}

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = "Login",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Username")},
            value = usernameField,
            onValueChange = { usernameField = it },
            trailingIcon = { //trailingIcon tekee kuvan kentän loppuun, leadingIcon vasempaan reunaan
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email icon"
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label= { Text("Password")},
            value = passwordField,
            onValueChange = { passwordField = it } ,
            trailingIcon = { //trailingIcon tekee kuvan kentän loppuun, leadingIcon vasempaan reunaan
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Email icon"
                )
            },
            visualTransformation = PasswordVisualTransformation(), //näyttää pisteenä kirjoituksen
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) //salasanalle sopiva keyboard
        )
        Button(
            onClick = {/*TODO*/},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Submit")
        }
    }
}
