package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.tags

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.ViewEvent
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class TagListViewModel: CleanViewModel() {

    override val interactor by inject(ITagsUseCases::class.java)

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _tagList = MutableLiveData(emptyList<TagEntity>())
    val tagList: LiveData<List<TagEntity>> = _tagList

    val errorEvent = MutableLiveData<ViewEvent<String>>()

    fun fetchTags() {

        _isLoading.value = true

        viewModelScope.launch {
            try {
                interactor.getTagList().let {
                    list -> _tagList.value = list
                }
            } catch (e: Exception) {
                "Error fetching tags".let { errorMessage ->
                    Log.d(errorMessage, e.toString())
                    errorEvent.postValue(ViewEvent(errorMessage))
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
}