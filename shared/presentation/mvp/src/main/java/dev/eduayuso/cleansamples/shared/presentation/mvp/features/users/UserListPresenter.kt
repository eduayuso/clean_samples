package dev.eduayuso.cleansamples.shared.presentation.mvp.features.users

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class UserListPresenter: CleanPresenter<IUserListEvents>() {

    override val interactor by inject(IUsersUseCases::class.java)

    fun fetchUsers() {

        this.listener?.showLoading()

        launch {

            try {
                val list = interactor.getUserList()
                Log.d("a", "${list.size}")
                listener?.onUserListFetched(list)

            } catch (e: Exception) {
                Log.d("Error fetching users", e.toString())

            } finally {
                listener?.hideLoading()
            }
        }
    }
}