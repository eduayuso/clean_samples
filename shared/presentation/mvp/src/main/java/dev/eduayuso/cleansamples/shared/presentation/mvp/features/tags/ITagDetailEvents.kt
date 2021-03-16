package dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

interface ITagDetailEvents: IViewEvents {

    fun showLoading()
    fun hideLoading()
    fun onPostsFetched(posts: List<PostEntity>)
    fun onError(message: String)
}