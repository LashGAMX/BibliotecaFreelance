package com.quantumy.bibliotecafreelance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quantumy.bibliotecafreelance.ui.theme.BibliotecaFreelanceTheme
import com.quantumy.bibliotecafreelance.views.AppNavigation
import com.quantumy.bibliotecafreelance.views.MainScreen

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
