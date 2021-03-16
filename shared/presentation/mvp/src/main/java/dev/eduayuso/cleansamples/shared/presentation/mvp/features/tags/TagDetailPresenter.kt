package dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.IUserDetailEvents
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class TagDetailPresenter: CleanPresenter<ITagDetailEvents>() {

    override val interactor by inject(ITagsUseCases::class.java)

    fun fetchPostsByTag(tag: String) {

        this.listener?.showLoading()

        launch {
            try {
                interactor.getPostsByTag(tag).let {
                    posts -> listener?.onPostsFetched(posts)
                }

            } catch (e: Exception) {
                "Error fetching tagged posts".let {
                    errorMessage ->
                    Log.d(errorMessage, e.toString())
                    listener?.onError(errorMessage)
                }
            } finally {
                listener?.hideLoading()
            }
        }
    }
}