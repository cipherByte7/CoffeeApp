
package com.example.coffeeapp.Presentation.screens.profileScreen


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.ui_components.BottomNavBar
import androidx.compose.material3.Switch
import androidx.compose.material3.TextButton
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.Presentation.ui_components.ProfileMenuItem
import com.example.coffeeapp.Presentation.viewmodel.ThemeViewModel
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import com.example.coffeeapp.data.datastore.TokenManager
import com.example.coffeeapp.data.remote.RetrofitInstance
import androidx.compose.material.icons.filled.Logout
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun ProfileScreen(navController: NavController) {
    var showAboutDialog by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    val tokenManager = remember {
        TokenManager(context)
    }

    val scope = rememberCoroutineScope()

    val themeViewModel: ThemeViewModel = viewModel(
        factory = ViewModelProvider.AndroidViewModelFactory.getInstance(
            androidx.compose.ui.platform.LocalContext.current.applicationContext as android.app.Application
        )
    )

    val isDarkTheme by themeViewModel.isDarkTheme.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { ProfileScreenTopAppBar() },
        bottomBar = { BottomNavBar(navController = navController, "Profile") }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .padding(innerPadding)
        ){
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
                    modifier = Modifier.padding(16.dp)
                ) {

                    ProfileMenuItem(
                        icon = Icons.Default.ShoppingCart,
                        title = "My Orders",
                        onClick = {
                            navController.navigate(Routes.OrderHistoryScreen)
                        }
                    )

                    ProfileMenuItem(
                        icon = Icons.Default.Favorite,
                        title = "Favourites",
                        onClick = {
                            navController.navigate(Routes.FavouritesScreen)
                        }
                    )

                    ProfileMenuItem(
                        icon = Icons.Default.WbSunny,
                        title = "Dark Mode",
                        trailingContent = {
                            Switch(
                                checked = isDarkTheme,
                                onCheckedChange = {
                                    themeViewModel.toggleTheme(it)
                                }
                            )
                        }
                    )

                    ProfileMenuItem(
                        icon = Icons.Default.Info,
                        title = "About App",
                        onClick = {
                            showAboutDialog = true
                        }
                    )

                    ProfileMenuItem(
                        icon = Icons.Default.Logout,
                        title = "Logout",
                        onClick = {

                            scope.launch {

                                tokenManager.clearToken()

                                RetrofitInstance.setToken(null)

                                navController.navigate(Routes.WelcomeScreen) {

                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = true
                                    }

                                    launchSingleTop = true
                                }
                            }
                        }
                    )

                }
            }

        }

    }

    if (showAboutDialog) {

        AlertDialog(

            onDismissRequest = {
                showAboutDialog = false
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showAboutDialog = false
                    }
                ) {
                    Text("Close")
                }

            },

            title = {
                Text("☕ Coffee App")
            },

            text = {

                Column {

                    Text("Version 1.0.0")

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Built with")

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("• Kotlin")
                    Text("• Jetpack Compose")
                    Text("• Node.js")
                    Text("• Express.js")
                    Text("• MongoDB")

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Developed by")

                    Text(
                        "Aaditya Chitale",
                        fontWeight = FontWeight.SemiBold
                    )

                }

            }

        )
    }

}
