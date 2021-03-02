package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class PostsInteractor: IPostsUseCases, IInteractor {

    override val data by inject(IDataManager::class.java)

    override suspend fun getPostList(): List<PostEntity> {

        val postsInCache = data.posts.cache.getAll()
        // Here you can do some cache logic to fetch from remote or not
        val cacheCond = postsInCache.isEmpty()
        return if (cacheCond) data.posts.remote.getAll()
        else emptyList()
    }

    override suspend fun readPost(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deletePost(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updatePost(post: PostEntity): PostEntity? {
        TODO("Not yet implemented")
    }
}