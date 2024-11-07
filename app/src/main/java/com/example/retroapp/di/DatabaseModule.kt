package com.example.retroapp.di

import androidx.room.Room
import com.example.retroapp.data.dp.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    // Singleton for the Room database
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "product_database"
        ).fallbackToDestructiveMigration() // Optional: handle migrations
            .build()
    }

    // Singleton for the ProductDao
    single { get<AppDatabase>().productDao() }
}
