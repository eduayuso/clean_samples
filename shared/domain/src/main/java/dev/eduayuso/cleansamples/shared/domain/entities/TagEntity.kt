package dev.eduayuso.cleansamples.shared.domain.entities

import kotlinx.serialization.Serializable

data class TagEntity(

    var id: String? = null

): IEntity

@Serializable
data class TagListResponse(

    val data: List<String>? = null,
    val total: Int? = null,
    val page: Int? = null
)