package com.example.coffeeapp.Presentation.screens.HomeScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import HomeCategories
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.coffeeapp.R
import com.example.coffeeapp.domain.modal.Product
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import com.example.coffeeapp.Presentation.theme.Poppins

//@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomeScreen(navController: NavController){
    val location = "Pune, Maharashtra"
    Scaffold(
        bottomBar = { BottomNavBar(navController, "Home") }
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


            //displaying products
            val products = listOf(
                Product(id = 1, "Expresso", "Strong & Rich", 15.99, R.drawable.expresso),
                Product(id = 2, "Cappuccino", "Rich & Creamy", 18.99, R.drawable.cappuccino),
                Product(id = 3, "Latte", "Creamy & Cold", 16.99, R.drawable.latte),
                Product(id = 4, "Mocha", "Espresso & Chocolate", 12.99, R.drawable.mocha),
                Product(id = 5, "Macchiato", "Espresso & Foamed Milk", 11.99, R.drawable.macchiato),
                Product(id = 6, "Iced Coffee", "Cold & Iced", 17.99, R.drawable.iced_coffee),
                Product(id = 7, "Hot Chocolate", "Rich & Creamy", 14.99, R.drawable.hot_chocolate)
            )

            ProductsGrid(products = products, navController = navController){
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

                Spacer(modifier = Modifier.height(30.dp))

                SearchBar()


                Image(
                    painter = painterResource(R.drawable.banner1),
                    contentDescription = "HomePageBanner",
                    //alignment = Alignment.TopCenter,
                    modifier = Modifier.width(460.dp).height(250.dp)
                        .padding(top = 30.dp, bottom = 20.dp)
                    // .clip(RoundedCornerShape(50.dp)),


                )

                HomeCategories()
            }

        }

    }

}
