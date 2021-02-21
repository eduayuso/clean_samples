package dev.eduayuso.cleansamples.shared.impl.source.remote

import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostListResponse
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserListResponse
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient
import org.koin.java.KoinJavaComponent

class PostsRemoteRepository: IRemoteRepository<String /*pk type*/, PostEntity> {

    val api by KoinJavaComponent.inject(ApiClient::class.java)

    private var postsUrl = DataConstants.Apis.DummyApi.posts
    private var limit    = "limit=10"

    override suspend fun getById(id: String) =
        TODO("Not yet implemented")

    override suspend fun getAll(): List<PostEntity> {

        val listWrapper = api.consume("$postsUrl?$limit").get().response(PostListResponse.serializer())
        return listWrapper?.data ?: emptyList()
    }

    override suspend fun insert(entity: PostEntity): PostEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: PostEntity): PostEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: PostEntity): Boolean {
        TODO("Not yet implemented")
    }
}