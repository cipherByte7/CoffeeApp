package com.example.coffeeapp.Presentation.screens.welcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.R
import com.example.coffeeapp.Presentation.theme.Poppins

@Composable
fun WelcomeScreen(navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black)){
        Image(
            painter = painterResource(R.drawable.welcomescreen),
            "Welcome Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 150.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Best way to start your day is Coffee!",
            color = Color.White,
            //fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            lineHeight = 34.sp,
            fontFamily = Poppins
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Welcome to Chitale's Cafe.",
            color = Color.LightGray,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontFamily = Poppins
        )

        Spacer(modifier = Modifier.height(440.dp))

        Button(
            onClick = {navController.navigate(Routes.HomeScreen)},
            modifier = Modifier.fillMaxWidth().height(55.dp),
            shape = RoundedCornerShape(28),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD2B48C),
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Let's Get Started!",
                fontSize = 17.sp,
                fontFamily = Poppins
            )
        }
    }
}
