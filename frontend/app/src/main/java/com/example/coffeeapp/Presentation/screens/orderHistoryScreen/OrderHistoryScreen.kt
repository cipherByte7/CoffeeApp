package com.example.coffeeapp.Presentation.screens.orderHistoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.navigation.Routes
import com.example.coffeeapp.Presentation.ui_components.LoadingIndicator
import com.example.coffeeapp.Presentation.viewmodel.OrderViewModel

@Composable
fun OrderHistoryScreen(
    navController: NavController
)  {

    val viewModel: OrderViewModel = viewModel()

    val orders = viewModel.orders

    if (viewModel.isLoading) {

        LoadingIndicator()

        return
    }

    if (orders.isEmpty()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No Orders Yet",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }

        return
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 38.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(orders) { order ->

            OrderCard(
                order = order,
                onClick = {
                    navController.navigate(
                        Routes.OrderDetailsScreen(order.id)
                    )
                }
            )

        }

    }
}