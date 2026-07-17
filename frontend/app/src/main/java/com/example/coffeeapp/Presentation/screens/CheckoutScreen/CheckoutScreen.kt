package com.example.coffeeapp.Presentation.screens.CheckoutScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.screens.cartScreen.PaymentModeSelectionCard
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.Presentation.viewmodel.CartViewModel
import com.example.coffeeapp.domain.model.CartItem
import androidx.compose.material3.CenterAlignedTopAppBar

@Composable
fun CheckoutScreen(navController: NavController) {

    val viewModel: CartViewModel = viewModel()
    val cartItems = viewModel.cartItems

    val amount = cartItems.sumOf { it.product.price * it.quantity }
    val deliveryFee = if (cartItems.isEmpty()) 0.0 else 1.50
    val totalBill = amount + deliveryFee

    Scaffold(
        topBar = { CheckoutTopAppBar(navController) },
        bottomBar = {

            PaymentModeSelectionCard(
                totalBill = totalBill,
                onPlaceOrder = { paymentMode ->

                    viewModel.placeOrder(
                        paymentMode = paymentMode,
                        onSuccess = {
                            navController.navigate(Routes.OrderSuccessScreen)
                        }
                    )

                }
            )

        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                DeliveryAddressCard()

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Order Summary",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                cartItems.forEach { cartItem ->
                    CheckoutOrderItemRow(cartItem)
                }

                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider(color = LightBrown.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Subtotal", fontFamily = Poppins, fontSize = 15.sp)
                    Text("$%.2f".format(amount), fontFamily = Poppins, fontSize = 15.sp)
                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Delivery Fee", fontFamily = Poppins, fontSize = 15.sp)
                    Text("$%.2f".format(deliveryFee), fontFamily = Poppins, fontSize = 15.sp)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Payment",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))



                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CheckoutTopAppBar(navController: NavController) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Checkout",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        },
    )
}

@Composable
private fun DeliveryAddressCard(
    label: String = "Home",
    address: String = "221B Baker Street, Pune, MH",
    onChangeClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = IvoryWhite,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Delivery Address",
                tint = LightBrown,
                modifier = Modifier.width(28.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Deliver to $label",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(
                    text = address,
                    fontFamily = Poppins,
                    fontSize = 13.sp,
                    color = Color.DarkGray
                )
            }

            Text(
                text = "Change",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                color = LightBrown,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable(onClick = onChangeClick)
            )
        }
    }
}

@Composable
private fun CheckoutOrderItemRow(cartItem: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = cartItem.product.imageResourceId),
            contentDescription = cartItem.product.name,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = cartItem.product.name,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = "Qty ${cartItem.quantity}",
                fontFamily = Poppins,
                fontSize = 12.sp,
                color = LightBrown
            )
        }

        Text(
            text = "$%.2f".format(cartItem.product.price * cartItem.quantity),
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}