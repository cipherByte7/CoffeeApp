package com.example.coffeeapp.Presentation.screens.favouriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeeapp.Presentation.viewmodel.FavoriteViewModel
import androidx.compose.runtime.LaunchedEffect
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.ui_components.EmptyState


@Composable
fun FavouritesScreen(navController: NavController) {
    val favoriteViewModel: FavoriteViewModel = viewModel()
    LaunchedEffect(Unit) {
        favoriteViewModel.loadFavorites()
    }
    val favoriteProducts = favoriteViewModel.favorites
    Scaffold(
        topBar = { FavouriteScreenTopAppBar() },
        bottomBar = { BottomNavBar(navController = navController, "Favourites") }
    ) { innerPadding ->
        if (favoriteProducts.isEmpty()) {

            EmptyState(
                icon = Icons.Outlined.FavoriteBorder,
                title = "No favorites yet",
                subtitle = "Tap the heart icon on a coffee to save it here.",
                buttonText = "Explore Coffee",
                onButtonClick = {
                    navController.navigate(Routes.HomeScreen)
                }
            )

        } else {

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
}


