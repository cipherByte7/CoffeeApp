package com.example.coffeeapp.screens.HomeScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.screens.ui_components.BottomNavBar
import com.example.coffeeapp.ui.theme.Poppins

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(){
    val location = "Pune, Maharashtra"
    Scaffold(
        bottomBar = { BottomNavBar() }
    ){ innerPadding ->

        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(1f/3f)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(color = 0xFF303030),
                        Color(color = 0xFF1F1F1F),
                        Color(color = 0xFF121212)
                    )
                )
            ).padding(innerPadding)
        )

        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp).padding(innerPadding)
        ) {
            Text(
                text = "Location",
                fontFamily = Poppins,
                color = Color.LightGray,
                fontSize = 13.sp,

            )

            Spacer(modifier = Modifier.height(3.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(text = location,
                    color = Color.White,
                    fontFamily = Poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Icon(imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "ArrowDropDown",
                    tint = Color.White
                )
            }
        }

    }

}