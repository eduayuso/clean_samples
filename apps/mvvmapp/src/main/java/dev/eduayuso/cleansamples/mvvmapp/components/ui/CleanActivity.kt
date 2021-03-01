package dev.eduayuso.cleansamples.mvvmapp.components.ui

import androidx.appcompat.app.AppCompatActivity
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel

abstract class CleanActivity: AppCompatActivity() {

    abstract val viewModel: CleanViewModel
}