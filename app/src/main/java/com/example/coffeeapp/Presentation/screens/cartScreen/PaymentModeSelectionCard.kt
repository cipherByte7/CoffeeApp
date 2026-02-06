package com.example.coffeeapp.Presentation.screens.cartScreen

import android.R.attr.mode
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.R

@Composable
fun PaymentModeSelectionCard(totalBill: Double) {

    var expanded by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf("Online") }
    val paymentModes = listOf("Cash", "Online", "Card")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    painter = painterResource(
                        id = when (selectedMode) {
                            "Online" -> R.drawable.mobile_banking
                            "Card" -> R.drawable.card
                            else -> R.drawable.cash
                        }
                    ),
                    contentDescription = "Payment Mode",
                    tint = LightBrown,
                    modifier = Modifier.size(36.dp)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Column {
                    Text(
                        text = selectedMode,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )

                    Text(
                        text = "₹$totalBill",
                        fontWeight = FontWeight.SemiBold,
                        color = LightBrown
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box {
                    Icon(
                        painter = painterResource(id = R.drawable.regular_outline_arrow_down),
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { expanded = true }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        paymentModes.forEach { mode ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = mode,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },


                                onClick = {
                                    selectedMode = mode
                                    expanded = false
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(
                                            id = when (mode) {
                                                "Online" -> R.drawable.mobile_banking
                                                "Card" -> R.drawable.card
                                                else -> R.drawable.cash
                                            }
                                        ),
                                        contentDescription = null,
                                        tint = LightBrown,
                                        modifier = Modifier.size(34.dp)
                                    )
                                },
                                modifier = Modifier
                                    .background(
                                        color =
                                            if(selectedMode == mode) LightBrown.copy(0.1f)
                                            else Color.Transparent
                                    )

                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Place Order",
                    fontSize = 17.sp,
                    fontFamily = Poppins
                )
            }
        }
    }
}
