package dev.eduayuso.cleansamples.shared.data.services

import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

abstract class IUsersService: IDataService<String, UserEntity>()