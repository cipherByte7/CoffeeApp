package com.example.coffeeapp.Presentation.screens.HomeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.ui_components.LoadingIndicator
import com.example.coffeeapp.domain.model.Product


@Composable
fun ProductsGrid(
    products: List<Product>,
    navController: NavController,
    onAddToCart: (String) -> Unit,
    isFavorite: (String) -> Boolean,
    onToggleFavorite: (String) -> Unit,
    isLoading: Boolean = false,
    topContent: @Composable () -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        item {
            topContent()
        }

        if (isLoading) {

            item {
                LoadingIndicator(modifier = Modifier.height(300.dp))
            }

        } else {

            items(products.chunked(2)) { rowItems ->

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ProductCard(
                        product = rowItems[0],
                        modifier = Modifier.weight(1f),
                        navController = navController,
                        onAddToCart = onAddToCart,
                        isFavorite = isFavorite(rowItems[0].id),
                        onToggleFavorite = onToggleFavorite
                    )


                    if (rowItems.size == 2) {
                        ProductCard(
                            product = rowItems[1],
                            modifier = Modifier.weight(1f),
                            navController = navController,
                            onAddToCart = onAddToCart,
                            isFavorite = isFavorite(rowItems[1].id),
                            onToggleFavorite = onToggleFavorite
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }

                }
            }
        }
    }
}


