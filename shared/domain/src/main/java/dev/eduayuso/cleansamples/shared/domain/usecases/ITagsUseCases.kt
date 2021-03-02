package dev.eduayuso.cleansamples.shared.domain.usecases

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity

interface ITagsUseCases: IUseCases {

    suspend fun getTagList(): List<TagEntity>

    suspend fun getPostsByTag(id: String): List<PostEntity>
}