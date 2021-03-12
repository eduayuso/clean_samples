package dev.eduayuso.cleansamples.shared.domain.entities

import kotlinx.serialization.Serializable

@Serializable
class CommentEntity(

    val id: String? = null,
    val owner: UserEntity? = null,
    val message: String? = null,
    val publishDate: String? = null

): IEntity

@Serializable
data class CommentListResponse(

    val data: List<CommentEntity>? = null,
    val total: Int? = null,
    val page: Int? = null
)