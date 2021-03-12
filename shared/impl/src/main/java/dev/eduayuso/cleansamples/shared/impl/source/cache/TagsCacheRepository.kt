package dev.eduayuso.cleansamples.shared.impl.source.cache

import dev.eduayuso.cleansamples.shared.data.repository.ICacheRepository
import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class TagsCacheRepository(

): ICacheRepository<String, TagEntity> {

    /**
     * Tag map by id
     */
    private val tags by lazy {
        HashMap<String /*tag id*/, TagEntity>()
    }

    override suspend fun getById(id: String) = tags[id]

    override suspend fun getAll() = tags.values.toList()

    override suspend fun insert(entity: TagEntity): TagEntity? {

        tags[entity.id ?: return null] = entity
        return entity
    }

    override suspend fun update(entity: TagEntity): TagEntity? {

        tags[entity.id ?: return null] = entity
        return entity
    }

    override suspend fun delete(entity: TagEntity): Boolean {

        return tags.remove(entity.id ?: return false) != null
    }
}