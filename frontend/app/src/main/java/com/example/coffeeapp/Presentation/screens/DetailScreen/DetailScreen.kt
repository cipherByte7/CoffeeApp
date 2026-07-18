package com.example.coffeeapp.Presentation.screens.DetailScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavHostController
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeeapp.Presentation.ui_components.LoadingIndicator
import com.example.coffeeapp.Presentation.viewmodel.DetailViewModel
import com.example.coffeeapp.R
import com.example.coffeeapp.domain.model.Product

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreen(productId: String, navController: NavHostController){

    val viewModel: DetailViewModel = viewModel()

    LaunchedEffect(productId) {
        viewModel.loadProduct(productId)
    }

    val selectedProduct = viewModel.product


    if (selectedProduct == null) {

        Scaffold(
            topBar = { DSTopAppBar(navController) }
        ) { innerPadding ->

            LoadingIndicator(modifier = Modifier.padding(innerPadding))
        }

        return
    }

    Scaffold(
        topBar = { DSTopAppBar(navController) },
        bottomBar = { DSBottomBar(product = selectedProduct) }
    ) { innerPadding ->

        LazyColumn() {
            item{
                ProductsDetailContent(  selectedProduct, innerPadding)
            }
        }
    }
}