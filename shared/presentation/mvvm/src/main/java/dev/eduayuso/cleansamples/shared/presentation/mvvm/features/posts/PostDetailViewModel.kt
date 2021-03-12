package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.ViewEvent
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class PostDetailViewModel: CleanViewModel() {

    override val interactor by inject(IPostsUseCases::class.java)

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _post = MutableLiveData<PostEntity>()
    val post: LiveData<PostEntity> = _post

    private val _postTags = MutableLiveData(emptyList<TagEntity>())
    val postTags: LiveData<List<TagEntity>> = _postTags

    private val _comments = MutableLiveData(emptyList<CommentEntity>())
    val comments: LiveData<List<CommentEntity>> = _comments

    val errorEvent = MutableLiveData<ViewEvent<String>>()

    fun getPost(postId: String) {

        viewModelScope.launch {
            try {
                interactor.getPost(postId).let { post ->
                    _post.postValue(post)
                    _postTags.postValue(post.tags?.map { TagEntity(it) })
                }
            } catch (e: Exception) {
                "Error getting post from cache".let { errorMessage ->
                    Log.d(errorMessage, e.toString())
                    errorEvent.postValue(ViewEvent(errorMessage))
                }
            } finally {
            }
        }
    }

    fun fetchPostComments(postId: String) {

        viewModelScope.launch {
            try {
                interactor.getPostComments(postId).let {
                    comments ->
                    _comments.postValue(comments)
                }
            } catch (e: Exception) {
                "Error fetching post comments".let {
                    errorMessage ->
                    Log.d(errorMessage, e.toString())
                    errorEvent.postValue(ViewEvent(errorMessage))
                }
            } finally {
            }
        }
    }
}