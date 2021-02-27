package dev.eduayuso.cleansamples.shared.domain.entities

import kotlinx.serialization.Serializable

@Serializable
class PostEntity(

    var id: String? = null,
    var text: String? = null,
    var image: String? = null,
    var likes: Int? = null,
    var publishDate: String? = null,
    var tags: List<String>? = null,
    var owner: UserEntity? = null

): IEntity

@Serializable
data class PostListResponse(

    val data: List<PostEntity>? = null,
    val total: Int? = null,
    val page: Int? = null
)