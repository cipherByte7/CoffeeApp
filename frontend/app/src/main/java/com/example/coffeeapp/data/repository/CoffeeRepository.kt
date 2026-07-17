package com.example.coffeeapp.data.repository

import com.example.coffeeapp.data.mapper.toCartItem
import com.example.coffeeapp.data.mapper.toOrder
import com.example.coffeeapp.data.mapper.toProduct
import com.example.coffeeapp.data.remote.AddToCartRequest
import com.example.coffeeapp.data.remote.PlaceOrderRequest
import com.example.coffeeapp.data.remote.RetrofitInstance
import com.example.coffeeapp.data.remote.UpdateCartRequest
import com.example.coffeeapp.domain.model.CartItem
import com.example.coffeeapp.domain.model.Order
import com.example.coffeeapp.domain.model.Product


class CoffeeRepository {

    suspend fun getProducts(
        search: String? = null,
        category: String? = null
    ): List<Product> {
        return try {
            val response = RetrofitInstance.api.getProducts(
                search = search,
                category = category
            )

            if (response.isSuccessful) {
                response.body()?.map { it.toProduct() } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getProductById(id: String): Product? {
        return try {
            val response = RetrofitInstance.api.getProductById(id)

            if (response.isSuccessful) {
                response.body()?.toProduct()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getCart(): List<CartItem> {
        return try {
            val response = RetrofitInstance.api.getCart()

            if (response.isSuccessful) {
                response.body()?.map { it.toCartItem() } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun addToCart(productId: String): CartItem? {
        return try {
            val response = RetrofitInstance.api.addToCart(
                AddToCartRequest(productId)
            )

            if (response.isSuccessful) {
                response.body()?.toCartItem()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun updateCartQuantity(
        id: String,
        quantity: Int
    ) {
        try {
            RetrofitInstance.api.updateCartQuantity(
                id,
                UpdateCartRequest(quantity)
            )
        } catch (e: Exception) {
            // Ignore for now
        }
    }

    suspend fun placeOrder(paymentMode: String): Order? {

        return try {

            val response = RetrofitInstance.api.placeOrder(
                PlaceOrderRequest(paymentMode)
            )

            android.util.Log.d("PLACE_ORDER", "Code = ${response.code()}")
            android.util.Log.d("PLACE_ORDER", "Body = ${response.body()}")
            android.util.Log.d(
                "PLACE_ORDER",
                "Error = ${response.errorBody()?.string()}"
            )

            if (response.isSuccessful) {
                response.body()?.toOrder()
            } else {
                null
            }

        } catch (e: Exception) {

            android.util.Log.e("PLACE_ORDER", "Exception", e)

            null
        }
    }

    suspend fun getOrders(): List<Order> {

        return try {

            val response = RetrofitInstance.api.getOrders()

            if (response.isSuccessful) {
                response.body()?.map { it.toOrder() } ?: emptyList()
            } else {
                emptyList()
            }

        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getOrderById(id: String): Order? {

        return try {

            val response = RetrofitInstance.api.getOrderById(id)

            if (response.isSuccessful) {
                response.body()?.toOrder()
            } else {
                null
            }

        } catch (e: Exception) {
            null
        }
    }
}