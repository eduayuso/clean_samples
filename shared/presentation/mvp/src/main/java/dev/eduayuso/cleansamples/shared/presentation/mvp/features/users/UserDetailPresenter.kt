package dev.eduayuso.cleansamples.shared.presentation.mvp.features.users

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class UserDetailPresenter: CleanPresenter<IUserDetailEvents>() {

    override val interactor by inject(IUsersUseCases::class.java)

    fun fetchUserDetail(userId: String) {

        launch {
            try {
                interactor.getUserDetail(userId)?.let {
                    userData -> listener?.onUserFetched(userData)
                } ?: run {
                    listener?.onError("User not found")
                }
            } catch (e: Exception) {
                "Error fetching user detail".let {
                    errorMessage ->
                    Log.d(errorMessage, e.toString())
                    listener?.onError(errorMessage)
                }
            } finally {
            }
        }
    }

    fun fetchUserPosts(userId: String) {

        this.listener?.showLoading()

        launch {
            try {
                interactor.getPostsByUser(userId).let {
                    userPosts -> listener?.onPostsFetched(userPosts ?: emptyList())
                }
            } catch (e: Exception) {
                "Error fetching user posts".let {
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