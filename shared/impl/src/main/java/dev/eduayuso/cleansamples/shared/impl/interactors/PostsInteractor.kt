package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.impl.source.remote.PostsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class PostsInteractor: IPostsUseCases, IInteractor {

    override val data by inject(IDataManager::class.java)

    override suspend fun getPost(postId: String): PostEntity {

        this.data.posts.cache.getById(postId)?.let {
            return it
        } ?: run {
            return this.data.posts.remote.getById(postId)!!
        }
    }

    override suspend fun getPostList(): List<PostEntity> {

        val postsInCache = data.posts.cache.getAll()
        // Here you can evaluate some cache logic to fetch from remote or not
        return if (postsInCache.isEmpty()) {
            val posts = data.posts.remote.getAll()
            posts.forEach { data.posts.cache.insert(it) }
            posts
        } else {
            postsInCache
        }
    }

    override suspend fun getPostComments(id: String): List<CommentEntity> {

        val postsRemote = data.posts.remote as PostsRemoteRepository
        return postsRemote.getComments(id)
    }
}