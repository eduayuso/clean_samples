package dev.eduayuso.cleansamples.shared.data.repository

import IRepository
import dev.eduayuso.cleansamples.shared.domain.entities.IEntity

interface ICacheRepository<KeyType, E: IEntity>: IRepository<KeyType, E>