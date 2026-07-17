package com.example.coffeeapp.Presentation.screens.favouriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import com.example.coffeeapp.R
import com.example.coffeeapp.domain.model.Product


@Composable
fun FavouritesScreen(navController: NavController) {
    var favouriteProducts by remember {
        mutableStateOf(
            listOf(
                Product(id = "1", "Expresso", "Strong & Rich", 15.99, R.drawable.expresso),
                Product(id = "2", "Cappuccino", "Rich & Creamy", 18.99, R.drawable.cappuccino),
                Product(id = "3", "Latte", "Creamy & Cold", 16.99, R.drawable.latte),
            )
        )
    }

    Scaffold(
        topBar = { FavouriteScreenTopAppBar() },
        bottomBar = { BottomNavBar(navController = navController, "Favourites") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)

        ) {
            item {
                favouriteProducts.forEach { product ->
                    FavouriteItemCard(
                        product,
                        onRemove = {
                            favouriteProducts = favouriteProducts - product
                        }
                    )
                }
            }
        }
    }
}
