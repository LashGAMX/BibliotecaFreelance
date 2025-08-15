package com.quantumy.bibliotecafreelance.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.quantumy.bibliotecafreelance.data.NavItem
import com.quantumy.bibliotecafreelance.presentation.archivo.ArchivoPage
import com.quantumy.bibliotecafreelance.presentation.favorite.FavoritePage
import com.quantumy.bibliotecafreelance.presentation.home.HomePage

@Composable
fun MainScreen(
    navController: NavController,
) {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home,0),
        NavItem("Archivo", Icons.Default.ThumbUp,5),
        NavItem("Favorito", Icons.Default.Favorite,0),
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (navItem.badgeCount > 0)
                                        Badge(){
                                            Text(text = navItem.badgeCount.toString())
                                        }
                                }
                            ) {
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            }
                        },

                        label = {

                        },
                    )
                }
            }
        }
    ){ innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex, navController)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex: Int, navController: NavController){
    when(selectedIndex){
        0-> HomePage(navController)
        1-> ArchivoPage()
        2-> FavoritePage()
    }
}