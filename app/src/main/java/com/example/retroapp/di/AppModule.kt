package com.example.retroapp.di

import androidx.room.Room
import com.example.retroapp.api.ProductApiService
import com.example.retroapp.data.dp.AppDatabase
import com.example.retroapp.repository.ProductRepository
import com.example.retroapp.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // Provide Retrofit instance
    single {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiService::class.java)
    }

    // Provide ProductRepository
    single { ProductRepository(get(), get()) }

    // Provide Room database and DAO
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "product_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().productDao() }

    // ViewModel injection using Koin
    viewModel { ProductViewModel(get()) }
}
