package dev.eduayuso.cleansamples.shared.impl.source.cache

import dev.eduayuso.cleansamples.shared.data.repository.ICacheRepository
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class UsersCacheRepository(

): ICacheRepository<String, UserEntity> {

    private var loggedUser: String? = null

    private val users by lazy {
        HashMap<String /*id (pk)*/, UserEntity /*user instance*/>()
    }

    override suspend fun getById(id: String) = users[id]

    override suspend fun getAll() = users.values.toList()

    override suspend fun insert(entity: UserEntity): UserEntity? {

        users[entity.id ?: return null] = entity
        return entity
    }

    override suspend fun update(entity: UserEntity): UserEntity? {

        users[entity.id ?: return null] = entity
        return entity
    }

    override suspend fun delete(entity: UserEntity): Boolean {

        return users.remove(entity.id ?: return false) != null
    }
}