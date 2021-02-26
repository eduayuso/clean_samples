package dev.eduayuso.cleansamples.shared.impl.source.remote

import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserListResponse
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient
import kotlinx.serialization.builtins.ListSerializer
import org.koin.java.KoinJavaComponent.inject

class UsersRemoteRepository: IRemoteRepository<String, UserEntity> {

    val api by inject(ApiClient::class.java)

    private var usersUrl = DataConstants.Apis.DummyApi.users
    private var postsUrl = DataConstants.Apis.DummyApi.posts
    private var limit    = "limit=10"

    /**
     * GET https://dummyapi.io/data/api/user/0F8JIqi4zwvb77FGz6Wt
     */
    override suspend fun getById(id: String) =

        api.consume("$usersUrl/$id").get().response(UserEntity.serializer())

    /**
     * GET https://dummyapi.io/data/api/user?limit=10
     */
    override suspend fun getAll(): List<UserEntity> {

        val listWrapper = api.consume("$usersUrl?$limit").get().response(UserListResponse.serializer())
        return listWrapper?.data ?: emptyList()
    }

    override suspend fun insert(entity: UserEntity): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: UserEntity): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: UserEntity): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * https://dummyapi.io/data/api/user/0F8JIqi4zwvb77FGz6Wt/post?limit=10
     */
    suspend fun getPosts(id: String): List<PostEntity> {

        val url = "$usersUrl/$id/$postsUrl?$limit"
        var type = ListSerializer(PostEntity.serializer())

        return api.consume(url).get().response(type) ?: emptyList()
    }
}