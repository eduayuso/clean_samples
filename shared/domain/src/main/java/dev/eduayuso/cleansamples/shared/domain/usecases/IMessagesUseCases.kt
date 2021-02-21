package dev.eduayuso.cleansamples.shared.domain.usecases

import dev.eduayuso.cleansamples.shared.domain.entities.MessageEntity

interface IMessagesUseCases: IUseCases {

    suspend fun fetchInboxMessages(): List<MessageEntity>

    suspend fun fetchSentMessages(): Boolean

    suspend fun postMessage(message: MessageEntity): MessageEntity?

    suspend fun readMessage(id: Int): Boolean?

    suspend fun deleteMessage(id: Int): Boolean?
}