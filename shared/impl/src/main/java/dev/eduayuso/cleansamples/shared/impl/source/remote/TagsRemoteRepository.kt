package dev.eduayuso.cleansamples.shared.impl.source.remote

import dev.eduayuso.cleansamples.shared.data.repository.IRemoteRepository
import dev.eduayuso.cleansamples.shared.domain.entities.*
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient
import org.koin.java.KoinJavaComponent

class TagsRemoteRepository: IRemoteRepository<String /*pk type*/, TagEntity> {

    val api by KoinJavaComponent.inject(ApiClient::class.java)

    private var tagsUrl = DataConstants.Apis.DummyApi.tags
    private var limit    = "limit=10"

    override suspend fun getById(id: String) =
        TODO("Not yet implemented")

    override suspend fun getAll(): List<TagEntity> =

        api.consume("$tagsUrl?$limit").get().response(TagListResponse.serializer())?.let {
            listWrapper ->
            listWrapper.data?.map { TagEntity(id = it) }
        } ?: run {
            emptyList()
        }

    override suspend fun insert(entity: TagEntity): TagEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: TagEntity): TagEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: TagEntity): Boolean {
        TODO("Not yet implemented")
    }
}