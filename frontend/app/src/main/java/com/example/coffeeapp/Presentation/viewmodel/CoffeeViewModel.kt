package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.data.repository.CoffeeRepository

class CoffeeViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    private val allProducts = repository.getProducts()

    var products by mutableStateOf(allProducts)
        private set

    var searchText by mutableStateOf("")
        private set

    fun onSearchChange(query: String) {
        searchText = query

        products = allProducts.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun refreshProducts() {
        products = repository.getProducts()
    }
}
