package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import org.koin.java.KoinJavaComponent.inject

class UsersInteractor: IUsersUseCases, IInteractor {

    override val data by inject(IDataManager::class.java)

    override suspend fun getUserList(): List<UserEntity> {

        val usersInCache = data.users.cache.getAll()
        // Here you can do some cache logic to fetch from remote or not
        val cacheCond = usersInCache.isEmpty()
        return if (cacheCond) data.users.remote.getAll()
        else emptyList()
    }

    override suspend fun getUserDetail(id: String): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getUserPosts(id: String): List<PostEntity>? {
        TODO("Not yet implemented")
    }
}