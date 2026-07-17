package com.example.coffeeapp.Presentation.screens.favouriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeeapp.Presentation.viewmodel.FavoriteViewModel
import androidx.compose.runtime.LaunchedEffect



@Composable
fun FavouritesScreen(navController: NavController) {
    val favoriteViewModel: FavoriteViewModel = viewModel()
    LaunchedEffect(Unit) {
        favoriteViewModel.loadFavorites()
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
                favoriteViewModel.favorites.forEach { product ->
                    FavouriteItemCard(
                        product,
                        onRemove = {
                            favoriteViewModel.toggleFavorite(product.id)
                        }
                    )
                }
            }
        }
    }
}
