package dev.eduayuso.cleansamples.shared.presentation.mvp.features.feed

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class PostListPresenter: CleanPresenter<IPostListEvents>() {

    override val interactor by KoinJavaComponent.inject(IPostsUseCases::class.java)

    fun fetchPosts() {

        this.listener?.showLoading()

        launch {

            try {
                val list = interactor.getPostList()
                Log.d("a", "${list.size}")
                listener?.onPostListFetched(list)

            } catch (e: Exception) {
                Log.d("Error fetching posts", e.toString())

            } finally {
                listener?.hideLoading()
            }
        }
    }
}