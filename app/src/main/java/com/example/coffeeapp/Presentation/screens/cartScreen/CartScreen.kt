package com.example.coffeeapp.Presentation.screens.cartScreen

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import com.example.coffeeapp.R
import com.example.coffeeapp.domain.modal.Product


@Composable
fun CartScreen(navController: NavController){
    val cartProducts = listOf(
        Product(id = 1, "Expresso", "Strong & Rich", 15.99, R.drawable.expresso),
        Product(id = 2, "Cappuccino", "Rich & Creamy", 18.99, R.drawable.cappuccino),
        Product(id = 3, "Latte", "Creamy & Cold", 16.99, R.drawable.latte),
    )

    var amount by remember { mutableStateOf(12.50) }
    var deliveryFee by remember { mutableStateOf(1.50) }
    var totalBill by remember { mutableStateOf(amount + deliveryFee ) }




    Scaffold(
        topBar = { CartScreenTopAppBar() },
        bottomBar = { BottomNavBar() }

    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            item {

                Row() {
                    Text("Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                cartProducts.forEach { product ->
                    CartItemCard(product)
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text("Payment Summary",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ), fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Price", fontSize = 18.sp)
                    Text(" $ $amount")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Delivery Fee", fontSize = 18.sp)
                    Text("$ $deliveryFee")
                }

                Spacer(modifier = Modifier.height(16.dp))

                PaymentModeSelectionCard(totalBill)

            }
        }
    }
}