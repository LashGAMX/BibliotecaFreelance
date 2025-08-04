package com.quantumy.bibliotecafreelance.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = "main"){
        composable("main") {
            MainScreen(navController)
        }

        composable(
            "category/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ){navBackStackEntry ->
            val category = navBackStackEntry.arguments?.getString("category").toString()
            CategoryPage(title = category, navController = navController)
        }

    }
}