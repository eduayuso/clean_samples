package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.ViewEvent
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class UserDetailViewModel: CleanViewModel() {

    override val interactor by inject(IUsersUseCases::class.java)

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _user = MutableLiveData<UserEntity>()
    val user: LiveData<UserEntity> = _user

    private val _userPosts = MutableLiveData(emptyList<PostEntity>())
    val userPosts: LiveData<List<PostEntity>> = _userPosts

    val errorEvent = MutableLiveData<ViewEvent<String>>()
    val viewTitleEvent = MutableLiveData<ViewEvent<String>>()

    fun fetchUserDetail(userId: String) {

        viewModelScope.launch {
            try {
                interactor.getUserDetail(userId).let {
                    userData ->
                    _user.postValue(userData)
                    val name = "${userData?.firstName} ${userData?.lastName}"
                    viewTitleEvent.postValue(ViewEvent(name))
                }
            } catch (e: Exception) {
                "Error fetching user detail".let {
                    errorMessage ->
                    Log.d(errorMessage, e.toString())
                    errorEvent.postValue(ViewEvent(errorMessage))
                }
            } finally {
            }
        }
    }

    fun fetchUserPosts(userId: String) {

        _isLoading.value = true

        viewModelScope.launch {
            try {
                interactor.getPostsByUser(userId).let {
                    userPosts -> _userPosts.postValue(userPosts)
                }
            } catch (e: Exception) {
                "Error fetching user posts".let { errorMessage ->
                    Log.d(errorMessage, e.toString())
                    errorEvent.postValue(ViewEvent(errorMessage))
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
}