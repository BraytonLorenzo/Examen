package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.screens.LoginScreen
import com.example.examen.screens.Screen2
import com.example.examen.ui.theme.ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExamenApp()
                }
            }
        }
    }
}

@Composable
fun ExamenApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "LoginScreen") {

        composable("LoginScreen") {

            LoginScreen(navController)

        }

        composable("Screen2") {

            Screen2(navController)

        }
    }
}
