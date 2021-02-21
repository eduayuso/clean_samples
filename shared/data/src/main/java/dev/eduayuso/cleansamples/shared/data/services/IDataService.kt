package dev.eduayuso.cleansamples.shared.data.services

import dev.eduayuso.cleansamples.shared.data.repository.ICacheRepository
import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.IEntity

abstract class IDataService<KeyType, E: IEntity> {

    abstract val cache: ICacheRepository<KeyType, E>     // Runtime memory
    abstract val remote: IRemoteRepository<KeyType, E>   // implemented with Retrofit, Ktor or other

    // Other data sources
    // abstract val prefs: IPrefsRepository<E>  // implemented with SharedPreferences
    // abstract val db: IDbRepository<E>        // implemented with Room or SQLDelight, for example
}