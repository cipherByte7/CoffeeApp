package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.CartItem
import kotlinx.coroutines.launch
import android.util.Log
import com.example.coffeeapp.domain.model.Order

class CartViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    var cartItems by mutableStateOf<List<CartItem>>(emptyList())
        private set

    init {
        loadCart()
    }

    var placedOrder by mutableStateOf<Order?>(null)
        private set

    fun loadCart() {
        viewModelScope.launch {

            val items = repository.getCart()

            Log.d("COFFEE_CART", "Cart size = ${items.size}")

            cartItems = items
        }
    }

    fun addToCart(productId: String) {

        viewModelScope.launch {

            repository.addToCart(productId)

            loadCart()

        }
    }

    fun updateCartQuantity(
        cartId: String,
        quantity: Int
    ) {
        viewModelScope.launch {

            repository.updateCartQuantity(
                id = cartId,
                quantity = quantity
            )

            loadCart()

        }

    }

    fun placeOrder(paymentMode: String, onSuccess: () -> Unit) {

        viewModelScope.launch {

            val order = repository.placeOrder(paymentMode)

            if (order != null) {
                placedOrder = order
                cartItems = emptyList()   // cart is now empty on the backend too
                onSuccess()
            }
        }
    }
}