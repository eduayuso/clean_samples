package dev.eduayuso.cleansamples.shared.domain.entities

import kotlinx.serialization.Serializable

@Serializable
class MessageEntity(

    val id: String? = null,
    val title: String? = null,
    val content: String? = null,
    val date: String? = null,
    val isRead: Boolean? = false

): IEntity