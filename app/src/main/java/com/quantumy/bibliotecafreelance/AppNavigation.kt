package com.quantumy.bibliotecafreelance

import DrivePreview
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quantumy.bibliotecafreelance.presentation.category.CategoryPage
import com.quantumy.bibliotecafreelance.views.MainScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = "main"){
        composable("main") {
            MainScreen(navController)
        }

        composable(
            "category/{category}/{categoryName}",
            arguments = listOf(
                navArgument("category") { type = NavType.StringType },
                navArgument("categoryName") { type = NavType.StringType; defaultValue = "" } // opcional
            )
        ){navBackStackEntry ->
            val category = navBackStackEntry.arguments?.getString("category").orEmpty()
            val categoryName = navBackStackEntry.arguments?.getString("categoryName")?.takeIf { it.isNotEmpty() }

            CategoryPage(
                title = category,
                categoryName = categoryName,
                navController = navController
            )
        }

        composable(
            "drivePreview?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
            })
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url").orEmpty()
            DrivePreview(url)
        }

    }
}