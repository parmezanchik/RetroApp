package com.example.retroapp.di

import com.example.retroapp.repository.VideoRepository
import com.example.retroapp.viewmodel.VideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { VideoRepository(get()) }
    viewModel { VideoViewModel(get()) }
}