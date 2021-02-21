package dev.eduayuso.cleansamples.shared.presentation

import androidx.lifecycle.ViewModel
import dev.eduayuso.cleansamples.shared.domain.usecases.IUseCases

/**
 * Base ViewModel for this project
 */
abstract class CleanViewModel: ViewModel() {

    abstract val interactor: IUseCases
}