package dev.eduayuso.cleansamples.shared.presentation.mvp.features.users

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

interface IUserDetailEvents: IViewEvents {

    fun showLoading()
    fun hideLoading()
    fun onUserFetched(user: UserEntity)
    fun onPostsFetched(posts: List<PostEntity>)
    fun onError(message: String)
}