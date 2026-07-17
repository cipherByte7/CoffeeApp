package com.example.coffeeapp.Presentation.screens.orderDetailsScreen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.theme.Poppins
import com.example.coffeeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailsTopAppBar(
    navController: NavController
) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Order Details",
                modifier = Modifier.fillMaxWidth(),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_arrow_left),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        navController.navigateUp()
                    }
            )
        }
    )
}