package com.example.retroapp.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.retroapp.data.dp.entity.ProductEntity

class ProductDiffCallback : DiffUtil.ItemCallback<ProductEntity>() {
    override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
        // Порівнюємо по id (у вас id є у кожного продукту)
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
        // Порівнюємо всі поля продукту для перевірки, чи змінився вміст
        return oldItem == newItem
    }
}
