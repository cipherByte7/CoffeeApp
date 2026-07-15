package com.example.coffeeapp.Presentation.screens.DetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.Poppins

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductSizeChip(sizeText: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier){

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = if(selected) IvoryWhite else Color.White,)
                .border(1.dp, color = if(selected) LightBrown else Color.LightGray, RoundedCornerShape(12.dp))
                .height(46.dp)
                .clickable{ }
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(sizeText,
                color = if(selected) LightBrown else Color.LightGray,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold
            )
        }

}