package com.example.coffeeapp.Presentation.screens.cartScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.LightGray
import com.example.coffeeapp.R
import com.example.coffeeapp.domain.modal.Product

//@Preview
@Composable
fun CartItemCard(product: Product){

    var quantity by remember() {mutableStateOf(1) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = IvoryWhite,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(4.dp)

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = product.imageResourceId),
                contentDescription = "Coffee Image",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(text = product.name,
                    fontWeight = FontWeight.SemiBold)

                Text(text = product.description,
                    color = Color.DarkGray)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = { quantity-- },
                    enabled = quantity > 1,
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.2f),
                            shape = CircleShape
                        )
                    .size(30.dp)
                    ) { Icon(imageVector = Icons.Default.Remove, contentDescription = "Remove", tint = LightBrown) }

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = quantity.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 8.dp))

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(
                    onClick = { quantity++ },
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.2f),
                            shape = CircleShape
                        )
                        .size(30.dp)
                ){ Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = LightBrown) }

            }
        }
    }
}