package com.example.coffeeapp.Presentation.screens.DetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import com.example.coffeeapp.Presentation.theme.CharcoalGray
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightGray
import com.example.coffeeapp.domain.modal.Product

//@Preview
@Composable
fun ProductsDetailContent(
    product: Product, innerPaddingValues: PaddingValues
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding( innerPaddingValues)

    ) {
        Image(
            painter = painterResource(product.imageResourceId),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(product.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Ice/Hot",
                fontSize = 16.sp,
                color = Color.Gray,
                //color = CharcoalGray.copy(alpha = 0.8f),
                fontWeight = FontWeight.Medium
            )

            Icon(
                painter = painterResource(id = com.example.coffeeapp.R.drawable.default_bean),
                contentDescription = "Bean",
                modifier = Modifier
                    .background(
                        color = IvoryWhite,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(36.dp)
                    .padding(6.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        HorizontalDivider(
            color = Color.LightGray,
            thickness = 1.dp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            product.description,
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "Size",
            fontSize = 16.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))

        var selectedSize by remember { mutableStateOf("M") }


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            listOf("S", "M", "L").forEach{size ->
                ProductSizeChip(
                    sizeText = size,
                    selected = selectedSize == size,
                    onClick = { selectedSize = size },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                )
            }
        }

    }
}