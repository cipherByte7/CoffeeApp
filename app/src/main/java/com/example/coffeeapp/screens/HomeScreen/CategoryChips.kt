package com.example.coffeeapp.screens.HomeScreen

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.ui.theme.LightBrown
import com.example.coffeeapp.ui.theme.Poppins

@Composable
fun CategoryChips(text: String,
                  isSelected: Boolean,
                  onSelected: () -> Unit
){
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(38.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable{ isSelected }
            .background(if (isSelected) LightBrown.copy(0.8f) else LightBrown.copy(0.2f)),
        contentAlignment = Alignment.Center
    ){
        Text(text = text,
            fontSize = 14.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold
        )
    }
}