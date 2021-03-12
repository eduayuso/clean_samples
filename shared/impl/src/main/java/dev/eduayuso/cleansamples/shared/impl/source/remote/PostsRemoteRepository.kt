package dev.eduayuso.cleansamples.shared.impl.source.remote

import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.*
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient
import org.koin.java.KoinJavaComponent

class PostsRemoteRepository: IRemoteRepository<String /*pk type*/, PostEntity> {

    val api by KoinJavaComponent.inject(ApiClient::class.java)

    private var postsUrl = DataConstants.Apis.DummyApi.posts
    private var commentsUrl = DataConstants.Apis.DummyApi.comments
    private var limit    = "limit=10"

    override suspend fun getById(id: String) =

        api.consume("$postsUrl/$id").get().response(PostEntity.serializer())

    override suspend fun getAll(): List<PostEntity> {

        val listWrapper = api.consume("$postsUrl?$limit").get().response(PostListResponse.serializer())
        return listWrapper?.data ?: emptyList()
    }

    /**
     * https://dummyapi.io/data/api/post/SFAt3mJK0qu4QOd9LgSX/comment?limit=10
     */
    suspend fun getComments(id: String): List<CommentEntity> {

        val url = "$postsUrl/$id/$commentsUrl?$limit"
        var type = CommentListResponse.serializer()

        val listWrapper = api.consume(url).get().response(type)
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