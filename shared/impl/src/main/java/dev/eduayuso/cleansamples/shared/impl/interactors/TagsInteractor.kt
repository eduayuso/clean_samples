package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.impl.source.remote.TagsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class TagsInteractor: ITagsUseCases, IInteractor {

    override val data by inject(IDataManager::class.java)

    override suspend fun getTagList(): List<TagEntity> {

        val tagsInCache = data.tags.cache.getAll()
        // Here you can evaluate some cache logic to fetch from remote or not
        return if (tagsInCache.isEmpty()) {
            val tags = data.tags.remote.getAll()
            tags.forEach { data.tags.cache.insert(it) }
            tags
        } else {
            tagsInCache
        }
    }

    override suspend fun getPostsByTag(id: String): List<PostEntity> {

        val tagsRemote = data.tags.remote as TagsRemoteRepository
        return tagsRemote.getPostByTag(id)
    }
}