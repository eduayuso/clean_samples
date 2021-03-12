package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.tags

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class TagDetailViewModel: CleanViewModel() {

    override val interactor by inject(ITagsUseCases::class.java)

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _postList = MutableLiveData(emptyList<PostEntity>())
    val postList: LiveData<List<PostEntity>> = _postList

    fun fetchPostsByTag(tag: String) {

        _isLoading.value = true

        viewModelScope.launch {
            try {
                val list = interactor.getPostsByTag(tag)
                _postList.value = list
            } catch (e: Exception) {
                Log.d("Error fetching posts", e.toString())
            } finally {
                _isLoading.value = false
            }
        }
    }
}