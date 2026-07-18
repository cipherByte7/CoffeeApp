package com.example.coffeeapp.Presentation.ui_components

import android.R.attr.onClick
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.R
import com.example.coffeeapp.Presentation.theme.Poppins
import androidx.compose.foundation.layout.navigationBarsPadding



@Composable
fun BottomNavBar(navController: NavController, routes: String){
    val navItems = listOf(
        NavItem("Home", R.drawable.home, Routes.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag, Routes.CartScreen),
        NavItem("Favourites", R.drawable.regular_outline_heart, Routes.FavouritesScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24, Routes.ProfileScreen),

    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .navigationBarsPadding()
            .height(54.dp)
    ){
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(22.dp)
                    )

                },
                label = { Text( text = item.title,
                    fontFamily = Poppins
                )
                    },
                //modifier = Modifier.size(18.dp),
                onClick = {
                    navController.navigate(item.routes){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = item.title == routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(0.12f)
                )

            )

        }

    }
}



data class NavItem(
    val title: String,
    val icon: Int,
    val routes: Routes
){

}