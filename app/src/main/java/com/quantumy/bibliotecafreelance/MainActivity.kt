package com.quantumy.bibliotecafreelance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.quantumy.bibliotecafreelance.ui.theme.BibliotecaFreelanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaFreelanceTheme {
                AppNavigation()
            }
        }
    }
}
