package dev.eduayuso.cleansamples.shared.impl.source.cache

import dev.eduayuso.cleansamples.shared.data.repository.ICacheRepository
import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class TagsCacheRepository(

): ICacheRepository<String, TagEntity> {

    /**
     * Posts by user
     */
    private val posts by lazy {
        HashMap<String /*tag id*/, TagEntity>()
    }

    override suspend fun getById(id: String) = posts[id]

    override suspend fun getAll() = posts.values.toList()

    override suspend fun insert(entity: TagEntity): TagEntity? {

        TODO("Not yet implemented")
    }

    override suspend fun update(entity: TagEntity): TagEntity? {

        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: TagEntity): Boolean {

        TODO("Not yet implemented")
    }
}