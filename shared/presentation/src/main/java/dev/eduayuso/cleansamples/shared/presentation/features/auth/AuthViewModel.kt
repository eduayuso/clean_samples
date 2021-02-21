package dev.eduayuso.cleansamples.shared.presentation.features.auth

import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.usecases.IUseCases
import dev.eduayuso.cleansamples.shared.presentation.CleanViewModel
import kotlinx.coroutines.launch

class AuthViewModel: CleanViewModel() {
    override val interactor: IUseCases
        get() = TODO("Not yet implemented")

    fun login() {

        viewModelScope.launch {

            //interactor.login("test", "asf")
        }
    }
}