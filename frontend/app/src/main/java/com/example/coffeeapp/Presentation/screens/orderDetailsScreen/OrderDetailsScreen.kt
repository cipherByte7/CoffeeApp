package com.example.coffeeapp.Presentation.screens.orderDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.Presentation.viewmodel.OrderDetailsViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun OrderDetailsScreen(
    orderId: String,
    navController: NavController
) {

    val viewModel: OrderDetailsViewModel = viewModel()

    LaunchedEffect(orderId) {
        viewModel.loadOrder(orderId)
    }

    val order = viewModel.order

    Scaffold(
        topBar = {
            OrderDetailsTopAppBar(navController)
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            if (order == null) {

                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(top = 50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

            } else {

                item {

                    Text(
                        text = "Order #${order.id.takeLast(6)}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Items",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }

                items(order.items.size) { index ->

                    val item = order.items[index]

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {

                            Text(
                                text = item.product.name,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = "Qty x${item.quantity}",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontFamily = Poppins
                            )

                        }

                        Text(
                            text = "$${"%.2f".format(item.product.price * item.quantity)}",
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                item {

                    Spacer(modifier = Modifier.height(16.dp))

                    HorizontalDivider()

                    Spacer(modifier = Modifier.height(20.dp))

                    DetailRow(
                        title = "Payment",
                        value = order.paymentMode
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DetailRow(
                        title = "Status",
                        value = order.status
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DetailRow(
                        title = "Placed On",
                        value = formatDate(order.createdAt)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    HorizontalDivider()

                    Spacer(modifier = Modifier.height(20.dp))

                    DetailRow(
                        title = "Total",
                        value = "$${"%.2f".format(order.totalAmount)}"
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

private fun formatDate(date: String): String {

    return try {

        val parser = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            Locale.getDefault()
        )

        val formatter = SimpleDateFormat(
            "dd MMM yyyy",
            Locale.getDefault()
        )

        formatter.format(parser.parse(date)!!)

    } catch (e: Exception) {

        date.take(10)

    }
}