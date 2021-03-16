package dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class PostListPresenter: CleanPresenter<IPostListEvents>() {

    override val interactor by inject(IPostsUseCases::class.java)

    fun fetchPosts() {

        this.listener?.showLoading()

        launch {

            try {
                interactor.getPostList().let {
                    posts -> listener?.onPostListFetched(posts)
                }

            } catch (e: Exception) {
                "Error fetching posts".let {
                    Log.d(it, e.toString())
                    listener?.onError(it)
                }

            } finally {
                listener?.hideLoading()
            }
        }
    }
}