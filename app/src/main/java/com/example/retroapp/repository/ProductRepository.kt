package com.example.retroapp.repository

import com.example.retroapp.api.ProductApiService
import com.example.retroapp.data.dp.dao.ProductDao
import com.example.retroapp.data.dp.entity.ProductEntity
import com.example.retroapp.data.toProductEntity

class ProductRepository(
    private val productApiService: ProductApiService,
    private val productDao: ProductDao
) {

    // Метод для отримання всіх продуктів з Room
    suspend fun getAllProducts(): List<ProductEntity> {
        return productDao.getAllProducts()
    }

    // Метод для отримання і збереження продуктів через Retrofit
    suspend fun fetchAndStoreProducts() {
        // Отримуємо продукти через API
        val response = productApiService.getProducts()

        // Якщо запит успішний, зберігаємо продукти в локальну базу даних
        if (response.isSuccessful) {
            val products = response.body()?.products ?: emptyList()
            // Перетворюємо продукти на ProductEntity та зберігаємо їх у базі даних
            val productEntities = products.filterNotNull().map { it.toProductEntity() }
            productDao.insertProducts(productEntities)
        }
    }

    // Метод для отримання окремого продукту через ID (можна додати для детальної інформації)
    suspend fun getProductById(id: Int): ProductEntity? {
        return productDao.getProductById(id)
    }
}
