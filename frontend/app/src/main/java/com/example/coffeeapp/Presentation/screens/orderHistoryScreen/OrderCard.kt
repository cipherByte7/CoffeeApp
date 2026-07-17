package com.example.coffeeapp.Presentation.screens.orderHistoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.domain.model.Order
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
private fun StatusColor(status: String): Color {

    return when(status){

        "Completed" -> Color(0xFF2E7D32)

        "Preparing" -> Color(0xFFFF9800)

        "Cancelled" -> Color.Red

        else -> LightBrown

    }

}
@Composable
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

@Composable
fun OrderCard(
    order: Order,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = IvoryWhite
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Coffee,
                    contentDescription = null,
                    tint = LightBrown
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Order #${order.id.takeLast(6)}",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .background(
                            StatusColor(order.status).copy(0.15f),
                            RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ){

                    Text(
                        text = order.status,
                        color = StatusColor(order.status),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )

                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "${order.items.size} Items",
                fontFamily = Poppins,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = order.paymentMode,
                fontFamily = Poppins,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {

                Text(
                    "Total",
                    fontFamily = Poppins,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    "$${"%.2f".format(order.totalAmount)}",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    color = LightBrown
                )

            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = LightBrown
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = formatDate(order.createdAt),
                    fontFamily = Poppins,
                    color = Color.Gray
                )

            }

        }

    }

}