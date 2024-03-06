package com.example.examen.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {

    val context = LocalContext.current

    val email = remember { mutableStateOf(TextFieldValue()) }
    val emailErrorState = remember { mutableStateOf(false) }

    val password = remember { mutableStateOf(TextFieldValue()) }
    val passwordErrorState = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append("S")
                }
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("ign")
                }
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append(" I")
                }
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("n")
                }
            },
            fontSize = 30.sp
        )

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                if (emailErrorState.value) {
                    emailErrorState.value = false
                }
                email.value = it
            },
            isError = emailErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Enter Email*") }
        )

        if (emailErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                if (passwordErrorState.value) {
                    passwordErrorState.value = false
                }
                password.value = it
            },
            isError = passwordErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Enter Password*") },
            visualTransformation = PasswordVisualTransformation()
        )

        if (passwordErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))

        Button(onClick = {
            when {
                email.value.text.isEmpty() -> {
                    emailErrorState.value = true
                }
                password.value.text.isEmpty() -> {
                    passwordErrorState.value = true
                }
                else -> {
                    passwordErrorState.value = false
                    emailErrorState.value = false
                    Toast.makeText(context, "Logged in successfully", Toast.LENGTH_SHORT).show()
                }
            }
        }) {
            Text(text = "Login")
        }
    }
}