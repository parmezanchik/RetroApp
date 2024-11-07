package com.example.retroapp.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retroapp.DetailProductActivity
import com.example.retroapp.data.dp.entity.ProductEntity
import com.example.retroapp.databinding.ItemProductBinding

class ProductAdapter : ListAdapter<ProductEntity, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductEntity) {
            // Без використання DataBinding, вручну присвоюємо текст
            binding.textViewTitle.text = product.title
            binding.textViewPrice.text = product.price.toString()

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailProductActivity::class.java)
                intent.putExtra("product", product) // Передаємо об'єкт ProductEntity
                itemView.context.startActivity(intent)
            }
        }
    }
}

