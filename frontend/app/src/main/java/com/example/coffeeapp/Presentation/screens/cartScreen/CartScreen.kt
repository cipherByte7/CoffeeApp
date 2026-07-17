package com.example.coffeeapp.Presentation.screens.cartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import com.example.coffeeapp.Presentation.ui_components.EmptyState
import com.example.coffeeapp.Presentation.viewmodel.CartViewModel

@Composable
fun CartScreen(navController: NavController) {

    val viewModel: CartViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.loadCart()
    }

    val cartItems = viewModel.cartItems

    val amount = cartItems.sumOf {
        it.product.price * it.quantity
    }

    val deliveryFee = if (cartItems.isEmpty()) 0.0 else 1.50

    val totalBill = amount + deliveryFee

    Scaffold(

        topBar = {
            CartScreenTopAppBar(navController = navController)
        },

        bottomBar = {

            Column {

                if (cartItems.isNotEmpty()) {

                    Button(
                        onClick = {
                            navController.navigate(Routes.CheckoutScreen)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LightBrown,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Proceed to Checkout",
                            fontSize = 17.sp,
                            fontFamily = Poppins
                        )
                    }

                }

                BottomNavBar(
                    navController = navController,
                    "Cart"
                )
            }
        }

    ) { innerPadding ->

        if (cartItems.isEmpty()) {

            EmptyState(
                modifier = Modifier.padding(innerPadding),
                icon = Icons.Outlined.ShoppingCart,
                title = "Your cart is empty",
                subtitle = "Looks like you haven't added any coffee yet.",
                buttonText = "Continue Shopping",
                onButtonClick = {
                    navController.navigate(Routes.HomeScreen)
                }
            )

        } else {

            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                item {

                    Row {
                        Text(
                            text = "Deliver",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightBrown
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    cartItems.forEach { cartItem ->

                        CartItemCard(
                            cartItem = cartItem,
                            onQuantityChange = { newQuantity ->

                                viewModel.updateCartQuantity(
                                    cartId = cartItem.id,
                                    quantity = newQuantity
                                )

                            }
                        )

                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    HorizontalDivider(
                        color = LightBrown.copy(alpha = 0.2f)
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = "Payment Summary",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Price",
                            fontSize = 18.sp
                        )

                        Text(
                            text = "$%.2f".format(amount)
                        )

                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Delivery Fee",
                            fontSize = 18.sp
                        )

                        Text(
                            text = "$%.2f".format(deliveryFee)
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Total",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Text(
                            text = "$%.2f".format(totalBill),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = LightBrown
                        )

                    }

                    Spacer(modifier = Modifier.height(8.dp))

                }

            }

        }

    }

}