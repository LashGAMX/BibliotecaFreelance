package com.quantumy.bibliotecafreelance.presentation.category

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.quantumy.bibliotecafreelance.core.components.CardResouce
import com.quantumy.bibliotecafreelance.presentation.model.Category
import com.quantumy.bibliotecafreelance.presentation.viewmodel.CategoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryPage(
    title: String? = "Sin titulo",
    categoryName: String? = null,
    navController: NavController,
    viewModel: CategoryViewModel = viewModel() // ✅ Usamos viewModel() para no recrearlo
) {
    val categories by viewModel.category.collectAsState()

    // ✅ Solo se ejecuta una vez al abrir la pantalla
    LaunchedEffect(Unit) {
        viewModel.getCategories(categoryName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack() // 1 pantalla atrás
                        navController.popBackStack() // 2 pantallas atrás
                        navController.popBackStack() // 2 pantallas atrás
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = { Text(title ?: "Sin título") }
            )
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding).padding(16.dp)) {
            LazyColumn {
                items(categories) { category ->
                    CategoryItem(category, navController)
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category,navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardResouce(
            id = 1,
            title = category.title.orEmpty(),
            description = category.description,
            imageResId = category.image,
            driveUrl = category.link,
//            navController = navController
        )
    }
}
