package com.example.coffeeapp.Presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.Order
import kotlinx.coroutines.launch

class OrderDetailsViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    var order by mutableStateOf<Order?>(null)
        private set

    fun loadOrder(orderId: String) {

        viewModelScope.launch {

            order = repository.getOrderById(orderId)

        }

    }
}