package com.example.coffeeapp.Presentation.screens.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.Presentation.ui_components.AppMessageDialogue
import com.example.coffeeapp.domain.modal.Product

//@Preview(showBackground = true)
@Composable
fun DSBottomBar(product: Product){

    var showCartDialogue by remember { mutableStateOf(false) }

    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Column() {
                Text(
                    "Price",
                    fontSize = 16.sp
                )

                //Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = product.price.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.width(30.dp))
            Button(
                onClick = { showCartDialogue = true },
                modifier = Modifier.weight(1f)
                    .height(70.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = IvoryWhite
                )


            ) {
                Text("Add to Cart",
                        fontSize = 16.sp,
                    color = IvoryWhite,
                    fontFamily = Poppins
                    )
            }

            AppMessageDialogue(
                show = showCartDialogue,
                title = "Item Added",
                message = "Item has been added to your cart",
                onDismiss = { showCartDialogue = false}
            )
        }
    }
}