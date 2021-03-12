package dev.eduayuso.cleansamples.shared.impl.source.cache

import dev.eduayuso.cleansamples.shared.data.repository.ICacheRepository
import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class PostsCacheRepository(

): ICacheRepository<String, PostEntity> {

    /**
     * Posts by id
     */
    private val posts by lazy {
        HashMap<String /*post id*/, PostEntity>()
    }

    override suspend fun getById(id: String) = posts[id]

    override suspend fun getAll() = posts.values.toList()

    override suspend fun insert(entity: PostEntity): PostEntity? {

        posts[entity.id ?: return null] = entity
        return entity
    }

    override suspend fun update(entity: PostEntity): PostEntity? {

        posts[entity.id ?: return null] = entity
        return entity
    }

    override suspend fun delete(entity: PostEntity): Boolean {

        return posts.remove(entity.id ?: return false) != null
    }
}