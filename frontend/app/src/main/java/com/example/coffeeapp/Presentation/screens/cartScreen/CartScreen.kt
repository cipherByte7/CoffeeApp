package com.example.coffeeapp.Presentation.screens.cartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeeapp.Presentation.viewmodel.CartViewModel
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.theme.Poppins
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.CenterAlignedTopAppBar


@Composable
fun CartScreen(navController: NavController){

    val viewModel: CartViewModel = viewModel()

// Re-fetch the cart every time this screen enters composition
// (e.g. every time the user taps the Cart tab), instead of only
// relying on the ViewModel's init{} block, since the ViewModel
// instance is preserved across bottom-nav navigation (restoreState = true)
    LaunchedEffect(Unit) {
        viewModel.loadCart()
    }
    val cartItems = viewModel.cartItems
    println("CartScreen Recompose -> ${cartItems.size}")

    val amount = cartItems.sumOf {
        it.product.price * it.quantity
    }
    val deliveryFee = if (cartItems.isEmpty()) 0.0 else 1.50
    val totalBill = amount + deliveryFee




    Scaffold(
        topBar = { CartScreenTopAppBar(navController = navController) },
        bottomBar = {
            Column {
                Button(
                    onClick = { navController.navigate(Routes.CheckoutScreen) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(55.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightBrown,
                        contentColor = Color.White
                    ),
                    enabled = cartItems.isNotEmpty()
                ) {
                    Text("Proceed to Checkout", fontSize = 17.sp, fontFamily = Poppins)
                }

                BottomNavBar(navController = navController, "Cart")
            }
        }

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

                HorizontalDivider(color = LightBrown.copy(alpha = 0.2f))

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
                    Text("$%.2f".format(amount))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Delivery Fee", fontSize = 18.sp)
                    Text("$%.2f".format(deliveryFee))
                }

                Spacer(modifier = Modifier.height(16.dp))



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
//                    Text(
//                        text = "Total",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp
//                    )

//                    Text(
//                        text = "$%.2f".format(totalBill),
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        color = LightBrown
//                    )
                }

                Spacer(modifier = Modifier.height(8.dp))



            }
        }
    }
}