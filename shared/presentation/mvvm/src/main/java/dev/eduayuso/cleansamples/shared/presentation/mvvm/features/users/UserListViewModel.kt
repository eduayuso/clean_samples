package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class UserListViewModel: CleanViewModel() {

    override val interactor by inject(IUsersUseCases::class.java)

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _userList = MutableLiveData(emptyList<UserEntity>())
    val userList: LiveData<List<UserEntity>> = _userList

    fun fetchUsers() {

        _isLoading.value = true

        viewModelScope.launch {
            try {
                val list = interactor.getUserList()
                _userList.value = list
            } catch (e: Exception) {
                Log.d("Error fetching users", e.toString())
            } finally {
                _isLoading.value = false
            }
        }
    }
}