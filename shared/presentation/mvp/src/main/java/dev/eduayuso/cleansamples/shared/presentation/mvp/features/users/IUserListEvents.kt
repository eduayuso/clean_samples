package dev.eduayuso.cleansamples.shared.presentation.mvp.features.users

import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

interface IUserListEvents: IViewEvents {

    fun showLoading()
    fun hideLoading()
    fun onUserListFetched(users: List<UserEntity>)
}