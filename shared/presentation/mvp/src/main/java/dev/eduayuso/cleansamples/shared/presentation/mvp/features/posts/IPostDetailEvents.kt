package dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts

import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

interface IPostDetailEvents: IViewEvents {

    fun showLoading()
    fun hideLoading()
    fun onPostDetailFetched(post: PostEntity, tags: List<TagEntity>)
    fun onPostCommentsFetched(comments: List<CommentEntity>)
    fun onError(message: String)
}