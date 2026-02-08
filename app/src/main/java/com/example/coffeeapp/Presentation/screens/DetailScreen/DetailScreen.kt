package com.example.coffeeapp.Presentation.screens.DetailScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.coffeeapp.R
import com.example.coffeeapp.domain.modal.Product

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreen(productId: Int, navController: NavHostController){

    val products = listOf(
        Product(id = 1, "Expresso", "Strong & Rich", 15.99, R.drawable.expresso),
        Product(id = 2, "Cappuccino", "Rich & Creamy", 18.99, R.drawable.cappuccino),
        Product(id = 3, "Latte", "Creamy & Cold", 16.99, R.drawable.latte),
        Product(id = 4, "Mocha", "Espresso & Chocolate", 12.99, R.drawable.mocha),
        Product(id = 5, "Macchiato", "Espresso & Foamed Milk", 11.99, R.drawable.macchiato),
        Product(id = 6, "Iced Coffee", "Cold & Iced", 17.99, R.drawable.iced_coffee),
        Product(id = 7, "Hot Chocolate", "Rich & Creamy", 14.99, R.drawable.hot_chocolate)
    )

    val selectedProduct = products.find { it.id == productId }

    if(selectedProduct == null){
        Text("Product not found", color = Color.Red)
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