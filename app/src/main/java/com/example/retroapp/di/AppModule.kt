package com.example.retroapp.di

import com.example.retroapp.repository.ProductRepository
import com.example.retroapp.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ProductRepository(get()) }
    viewModel { ProductViewModel(get()) }
}