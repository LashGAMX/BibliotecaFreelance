package com.quantumy.bibliotecafreelance.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quantumy.bibliotecafreelance.R
import com.quantumy.bibliotecafreelance.core.components.CardMenu
import com.quantumy.bibliotecafreelance.core.theme.Background
import com.quantumy.bibliotecafreelance.data.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomePage(modifier: Modifier = Modifier) {

    val menuItem = listOf<MenuItem>(
        MenuItem(1,"Contratos"),
        MenuItem(2,"Finanzas"),
    )
    Scaffold (
        topBar = {
            TopAppBar( title = { Text("explora recursos") })
        },
    ){ contentPadding ->
        Column (
            modifier = Modifier.padding(contentPadding).padding(16.dp)
        ){
            menuItem.forEach { item ->
                CardMenu(item.name,"Sin descripcion", R.drawable.contrato)
            }
        }

    }
}