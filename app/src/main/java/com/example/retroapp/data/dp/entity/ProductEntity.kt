package com.example.retroapp.data.dp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String = "", // Default empty string for description
    val price: Double = 0.0, // Default price of 0.0
    val thumbnail: String = "" // Default empty string for thumbnail
): Serializable