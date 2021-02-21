package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.MessageEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IMessagesUseCases

class MessagesInteractor(

    override val data: IDataManager

): IMessagesUseCases, IInteractor {

    override suspend fun fetchInboxMessages(): List<MessageEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchSentMessages(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun postMessage(message: MessageEntity): MessageEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun readMessage(id: Int): Boolean? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMessage(id: Int): Boolean? {
        TODO("Not yet implemented")
    }
}