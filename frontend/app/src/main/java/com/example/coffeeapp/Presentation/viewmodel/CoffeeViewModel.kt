package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.Product
import kotlinx.coroutines.launch

class CoffeeViewModel : ViewModel() {

    var selectedCategory by mutableStateOf("All Coffee")
        private set
    private val repository = CoffeeRepository()

    private var allProducts = listOf<Product>()

    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    var searchText by mutableStateOf("")
        private set

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {

            allProducts = repository.getProducts()
            products = allProducts

        }
    }

    fun onSearchChange(query: String) {

        searchText = query

        viewModelScope.launch {

            products = repository.getProducts(
                search = searchText,
                category = selectedCategory
            )

        }
    }

    fun onCategorySelected(category: String?) {

        selectedCategory = category ?: "All Coffee"

        this.selectedCategory = selectedCategory

        viewModelScope.launch {

            products = repository.getProducts(
                search = searchText,
                category = category
            )

        }
    }
}