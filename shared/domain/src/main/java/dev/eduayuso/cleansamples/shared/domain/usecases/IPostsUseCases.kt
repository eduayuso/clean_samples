package dev.eduayuso.cleansamples.shared.domain.usecases

import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity

interface IPostsUseCases: IUseCases {

    suspend fun getPost(postId: String): PostEntity

    suspend fun getPostList(): List<PostEntity>

    suspend fun getPostComments(id: String): List<CommentEntity>
}