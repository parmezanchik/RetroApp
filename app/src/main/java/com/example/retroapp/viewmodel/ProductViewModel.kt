package com.example.retroapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.retroapp.data.dp.entity.ProductEntity
import com.example.retroapp.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    // LiveData для списку продуктів
    val products: LiveData<List<ProductEntity>> = liveData {
        val productList = productRepository.getAllProducts()
        emit(productList) // Відправляємо список продуктів
    }

    // Завантаження продуктів через ViewModelScope
    fun loadProducts() {
        viewModelScope.launch {
            productRepository.fetchAndStoreProducts()
        }
    }
}
