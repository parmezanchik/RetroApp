package com.example.retroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retroapp.R
import com.example.retroapp.recyclerview.ProductAdapter
import com.example.retroapp.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Використовуємо Koin для ін'єкції ProductViewModel
    private val productViewModel: ProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ProductAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Спостерігаємо за змінами в списку продуктів
        productViewModel.products.observe(this) { products ->
            adapter.submitList(products)
        }

        // Завантажуємо продукти
        productViewModel.loadProducts()
    }
}
