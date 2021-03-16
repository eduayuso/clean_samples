package dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

interface IPostListEvents: IViewEvents {

    fun showLoading()
    fun hideLoading()
    fun onError(message: String)
    fun onPostListFetched(posts: List<PostEntity>)
}