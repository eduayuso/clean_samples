package dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class PostDetailPresenter: CleanPresenter<IPostDetailEvents>() {

    override val interactor by inject(IPostsUseCases::class.java)

    fun getPost(postId: String) {

        launch {
            try {
                interactor.getPost(postId).let { post ->
                    val tags = post.tags?.map { TagEntity(it) }
                    listener?.onPostDetailFetched(post, tags ?: emptyList())
                }
            } catch (e: Exception) {
                "Error getting post from cache".let {
                    errorMessage ->
                    Log.d(errorMessage, e.toString())
                    listener?.onError(errorMessage)
                }
            } finally {
            }
        }
    }

    fun fetchPostComments(postId: String) {

        launch {
            try {
                interactor.getPostComments(postId).let {
                    comments ->
                    listener?.onPostCommentsFetched(comments)
                }
            } catch (e: Exception) {
                "Error fetching post comments".let {
                    errorMessage ->
                    Log.d(errorMessage, e.toString())
                    listener?.onError(errorMessage)
                }
            } finally {
            }
        }
    }
}