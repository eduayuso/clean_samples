package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class TagsInteractor: ITagsUseCases, IInteractor {

    override val data by inject(IDataManager::class.java)

    override suspend fun getTagList(): List<TagEntity> {

        return data.tags.remote.getAll()
    }

    override suspend fun getPostsByTag(id: String): List<PostEntity> {
        TODO("Not yet implemented")
    }
}