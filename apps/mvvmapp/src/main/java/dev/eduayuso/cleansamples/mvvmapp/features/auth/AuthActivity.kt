package dev.eduayuso.cleansamples.mvvmapp.features.auth

import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanActivity
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.auth.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity : CleanActivity() {

    override val viewModel : AuthViewModel by viewModel()
}