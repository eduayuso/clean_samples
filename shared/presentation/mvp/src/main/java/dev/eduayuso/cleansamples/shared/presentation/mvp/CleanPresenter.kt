package dev.eduayuso.cleansamples.shared.presentation.mvp

import dev.eduayuso.cleansamples.shared.domain.usecases.IUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Base View Presenter for this project
 */
abstract class CleanPresenter<ViewListenerClass>: CoroutineScope {

    abstract val interactor: IUseCases

    var listener: ViewListenerClass? = null

    private val job = Job()
    override val coroutineContext = job + Dispatchers.Main
}