package com.example.coffeeapp.Presentation.ui_components

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
import com.example.coffeeapp.R
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins


@Preview
@Composable
fun BottomNavBar(){
    val navItems = listOf(
        NavItem("Home", R.drawable.home),
        NavItem("Cart", R.drawable.regular_outline_bag),
        NavItem("Favourites", R.drawable.regular_outline_heart),
        NavItem("Profile", R.drawable.outline_account_circle_24),

    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier =  Modifier.height(100.dp)
    ){
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title
                    )

                },
                label = { Text( text = item.title,
                    fontFamily = Poppins
                )
                    },
                modifier = Modifier.size(20.dp),
                onClick = {  },
                selected = true,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(0.04f)
                )

            )

        }

    }
}



data class NavItem(
    val title: String,
    val icon: Int
){

}