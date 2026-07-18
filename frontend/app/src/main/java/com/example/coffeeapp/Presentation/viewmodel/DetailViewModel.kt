package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.Product
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    var product by mutableStateOf<Product?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadProduct(productId: String) {

        viewModelScope.launch {

            isLoading = true

            product = repository.getProductById(productId)

            isLoading = false

        }
    }
}