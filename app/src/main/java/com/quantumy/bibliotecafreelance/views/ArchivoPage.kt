package com.quantumy.bibliotecafreelance.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun ArchivoPage(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize().background(Color.Red),
        verticalArrangement = Arrangement.Center, // Centrado en la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centrado en la pantalla
    ){
        Text(
            text = "Archivo Page",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}