package dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class TagListPresenter: CleanPresenter<ITagListEvents>() {

    override val interactor by inject(ITagsUseCases::class.java)

    fun fetchTags() {

        this.listener?.showLoading()

        launch {
            try {
                interactor.getTagList().let {
                    list -> listener?.onTagListFetched(list)
                }
            } catch (e: Exception) {
                "Error fetching tags".let { errorMessage ->
                    Log.d(errorMessage, e.toString())
                }
            } finally {
                listener?.hideLoading()
            }
        }
    }
}