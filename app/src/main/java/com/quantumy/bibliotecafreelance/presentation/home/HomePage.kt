package com.quantumy.bibliotecafreelance.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.quantumy.bibliotecafreelance.R
import com.quantumy.bibliotecafreelance.core.components.CardMenu
import com.quantumy.bibliotecafreelance.data.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomePage(
    navController: NavController
) {

    val menuItem = listOf<MenuItem>(
        MenuItem(1,"Contratos", R.drawable.contrato),
        MenuItem(2,"Finanzas", R.drawable.finanzas),
        MenuItem(2,"Diseño", R.drawable.disenio),
        MenuItem(2,"Marketing", R.drawable.marketing),
        MenuItem(2,"Facturacion", R.drawable.facturacion),
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
                CardMenu(item.name,"Sin descripcion", item.icon,navController)
            }
        }

    }
}