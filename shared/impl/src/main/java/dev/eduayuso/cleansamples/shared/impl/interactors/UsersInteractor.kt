package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import org.koin.java.KoinJavaComponent.inject

class UsersInteractor: IUsersUseCases, IInteractor {

    override val data by inject(IDataManager::class.java)

    /**
     * Returns the user list from cache or, if it's empty, from remote
     */
    override suspend fun getUserList(): List<UserEntity> {

        val usersInCache = data.users.cache.getAll()
        // Here you can do some cache logic to fetch from remote or not
        return if (usersInCache.isEmpty()) {
            val users = data.users.remote.getAll()
            users.forEach { data.users.cache.insert(it) }
            users
        } else {
            usersInCache
        }
    }

    /**
     * Return user detail: location property is not retrieved in user list fetch
     */
    override suspend fun getUserDetail(id: String): UserEntity? {

        return data.users.remote.getById(id)
    }

    /**
     * Returns user posts
     */
    override suspend fun getPostsByUser(id: String): List<PostEntity>? {

        val usersRemote = data.users.remote as UsersRemoteRepository
        val posts = usersRemote.getPosts(id)
        return posts
    }
}