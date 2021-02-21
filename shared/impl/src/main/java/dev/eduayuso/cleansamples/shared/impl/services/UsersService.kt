package dev.eduayuso.cleansamples.shared.impl.services

import dev.eduayuso.cleansamples.shared.data.services.IUsersService
import dev.eduayuso.cleansamples.shared.impl.source.cache.UsersCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import org.koin.java.KoinJavaComponent.inject

class UsersService: IUsersService() {

    override val cache by inject(UsersCacheRepository::class.java)
    override val remote by inject(UsersRemoteRepository::class.java)
    // override val remote: UsersPrefsRepository,
    // override val remote: UsersDbRepository
}