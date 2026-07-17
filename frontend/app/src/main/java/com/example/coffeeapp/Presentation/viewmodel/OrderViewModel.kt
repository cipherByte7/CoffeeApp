package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.Order
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    var orders by mutableStateOf<List<Order>>(emptyList())
        private set

    init {
        loadOrders()
    }

    fun loadOrders() {

        viewModelScope.launch {

            val list = repository.getOrders()

            android.util.Log.d("ORDER_TEST", list.toString())

            orders = list

        }

    }

}