package dev.eduayuso.cleansamples.shared.impl.services

import dev.eduayuso.cleansamples.shared.data.services.IMessagesService
import dev.eduayuso.cleansamples.shared.data.services.IUsersService
import dev.eduayuso.cleansamples.shared.impl.source.cache.MessagesCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.cache.UsersCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.MessagesRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository

class MessagesService(

    override val cache: MessagesCacheRepository,
    override val remote: MessagesRemoteRepository,
    // override val remote: MessagesPrefsRepository,
    // override val remote: MessagesDbRepository

): IMessagesService()