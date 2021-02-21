package dev.eduayuso.cleansamples.shared.data.services

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity

abstract class IPostsService: IDataService<String /*pk type*/, PostEntity>()