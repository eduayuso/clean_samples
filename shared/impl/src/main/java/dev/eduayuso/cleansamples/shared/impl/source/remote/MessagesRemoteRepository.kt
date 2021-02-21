package dev.eduayuso.cleansamples.shared.impl.source.remote

import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.MessageEntity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient

class MessagesRemoteRepository(

    val api: ApiClient

): IRemoteRepository<String, MessageEntity> {

    override suspend fun getById(id: String) =

        TODO("Not yet implemented")

    override suspend fun getAll(): List<MessageEntity> =

        TODO("Not yet implemented")

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