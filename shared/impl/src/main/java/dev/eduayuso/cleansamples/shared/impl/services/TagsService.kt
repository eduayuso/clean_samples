package dev.eduayuso.cleansamples.shared.impl.services

import dev.eduayuso.cleansamples.shared.data.services.IPostsService
import dev.eduayuso.cleansamples.shared.data.services.ITagsService
import dev.eduayuso.cleansamples.shared.impl.source.cache.PostsCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.cache.TagsCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.cache.UsersCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.PostsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.TagsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class TagsService: ITagsService() {

    override val cache by inject(TagsCacheRepository::class.java)
    override val remote by inject(TagsRemoteRepository::class.java)
    // override val remote: MessagesPrefsRepository,
    // override val remote: MessagesDbRepository
}