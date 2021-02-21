package dev.eduayuso.cleansamples.shared.data.services

import dev.eduayuso.cleansamples.shared.domain.entities.MessageEntity

abstract class IMessagesService: IDataService<String, MessageEntity>()