package dev.eduayuso.cleansamples.shared.impl.services

import dev.eduayuso.cleansamples.shared.data.services.IPostsService
import dev.eduayuso.cleansamples.shared.impl.source.cache.PostsCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.cache.UsersCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.PostsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class PostsService: IPostsService() {

    override val cache by inject(PostsCacheRepository::class.java)
    override val remote by inject(PostsRemoteRepository::class.java)
    // override val remote: MessagesPrefsRepository,
    // override val remote: MessagesDbRepository

}