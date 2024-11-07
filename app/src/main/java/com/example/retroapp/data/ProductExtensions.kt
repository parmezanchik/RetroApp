package com.example.retroapp.data

import com.example.retroapp.data.dp.entity.ProductEntity
import com.example.retroapp.data.ProductsItem

// Функція розширення для перетворення ProductsItem в ProductEntity
fun ProductsItem.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = this.id ?: 0, // Якщо id null, то присвоюємо значення 0
        title = this.title ?: "",
        description = this.description ?: "",
        price = (this.price as? Double) ?: 0.0, // Приводимо price до типу Double
        thumbnail = this.thumbnail ?: ""
    )
}
