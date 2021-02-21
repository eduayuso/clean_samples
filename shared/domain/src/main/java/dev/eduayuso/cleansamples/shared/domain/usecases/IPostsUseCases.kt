package dev.eduayuso.cleansamples.shared.domain.usecases

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity

interface IPostsUseCases: IUseCases {

    suspend fun getPostList(): List<PostEntity>

    suspend fun readPost(id: Int): Boolean

    suspend fun deletePost(id: Int): Boolean

    suspend fun updatePost(post: PostEntity): PostEntity?
}