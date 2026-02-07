package com.example.coffeeapp.Presentation.screens.profileScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar

@Composable
fun ProfileScreen(navController: NavController) {

    Scaffold(
        topBar = { ProfileScreenTopAppBar() },
        bottomBar = { BottomNavBar(navController = navController, "Profile") }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(
                            color = LightBrown.copy(0.2f),
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(85.dp),
                        tint = LightBrown

                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Aaditya Chitale",
                    modifier = Modifier,
                    style = MaterialTheme.typography.headlineLarge,

                    )
                Text(
                    "adityaschitale0816@gmail.com",
                    modifier = Modifier,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Text(
                "Address",
                modifier = Modifier,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "IIIT Bhubaneswar,\n" +
                        "Gothapatna, \n" +
                        "Odisha, \n" +
                        "751003",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyMedium,

                )

            Spacer(modifier = Modifier.height(28.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp )
                ) {


                    Row(
                        modifier = Modifier
                            .clickable{
                                navController.navigate(Routes.CartScreen)
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            tint = LightBrown
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "My Orders",
                        )

                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .clickable{
                                navController.navigate(Routes.FavouritesScreen)
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favourite",
                            tint = LightBrown
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Favourites",
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Theme",
                            tint = LightBrown
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Theme",
                        )

                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = LightBrown
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Settings",
                        )

                    }
                    Spacer(modifier = Modifier.height(12.dp))

                }
            }

        }

    }

}
