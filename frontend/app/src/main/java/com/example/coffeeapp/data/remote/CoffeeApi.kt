package com.example.coffeeapp.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CoffeeApi {

    @GET("api/products")
    suspend fun getProducts(
        @Query("search") search: String? = null,
        @Query("category") category: String? = null
    ): Response<List<ProductDto>>

    @GET("api/products/{id}")
    suspend fun getProductById(
        @Path("id") id: String
    ): Response<ProductDto>

    @GET("api/cart")
    suspend fun getCart(): Response<List<CartDto>>

    @POST("api/cart")
    suspend fun addToCart(
        @Body request: AddToCartRequest
    ): Response<CartDto>

    @PUT("api/cart/{id}")
    suspend fun updateCartQuantity(
        @Path("id") id: String,
        @Body request: UpdateCartRequest
    ): Response<CartDto>

    @POST("api/orders")
    suspend fun placeOrder(
        @Body request: PlaceOrderRequest
    ): Response<OrderDto>

    @GET("api/orders")
    suspend fun getOrders(): Response<List<OrderDto>>

    @GET("api/orders/{id}")
    suspend fun getOrderById(
        @Path("id") id: String
    ): Response<OrderDto>

    @POST("api/favorites/toggle")
    suspend fun toggleFavorite(
        @Body request: ToggleFavoriteRequest
    ): Response<ToggleFavoriteResponse>

    @GET("api/favorites")
    suspend fun getFavorites(): Response<List<FavoriteDto>>

    @POST("api/auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    @POST("api/auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("api/auth/profile")
    suspend fun getProfile(): Response<UserDto>

}