package dev.eduayuso.cleansamples.shared.impl.source.cache

import dev.eduayuso.cleansamples.shared.data.repository.ICacheRepository
import dev.eduayuso.cleansamples.shared.domain.entities.MessageEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class MessagesCacheRepository(

): ICacheRepository<String, MessageEntity> {

    private val messages by lazy {
        HashMap<Int /*id (pk)*/, MessageEntity /*message instance*/>()
    }

    override suspend fun getById(id: String): MessageEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<MessageEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(entity: MessageEntity): MessageEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: MessageEntity): MessageEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: MessageEntity): Boolean {
        TODO("Not yet implemented")
    }
}