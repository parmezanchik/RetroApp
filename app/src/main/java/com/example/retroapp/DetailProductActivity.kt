package com.example.retroapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retroapp.data.dp.entity.ProductEntity

class DetailProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        // Отримуємо дані про продукт з Intent
        val product = intent.getSerializableExtra("product") as ProductEntity

        // Відображаємо дані
        findViewById<TextView>(R.id.textViewTitle).text = product.title
        findViewById<TextView>(R.id.textViewPrice).text = product.price.toString()
        findViewById<TextView>(R.id.textViewDescription).text = product.description
    }
}
