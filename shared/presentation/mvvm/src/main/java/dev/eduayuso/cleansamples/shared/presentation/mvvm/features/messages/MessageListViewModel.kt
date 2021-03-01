package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.messages

import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.usecases.IUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import kotlinx.coroutines.launch

class MessageListViewModel: CleanViewModel() {
    override val interactor: IUseCases
        get() = TODO("Not yet implemented")

    fun login() {

        viewModelScope.launch {

            //interactor.login("test", "asf")
        }
    }
}