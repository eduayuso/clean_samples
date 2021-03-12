package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor

import dev.eduayuso.cleansamples.shared.impl.DataConstants
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*

object HttpMockApiClient {

    private val api = DataConstants.Apis.DummyApi

    object MockData {

        val userList        by lazy { readJsonFile("/users/userList.json") }
        val userDetail      by lazy { readJsonFile("/users/userDetail.json") }
        val userPosts       by lazy { readJsonFile("/users/userPosts.json") }

        val postList        by lazy { readJsonFile("/posts/postList.json") }
        val postComments    by lazy { readJsonFile("/posts/postComments.json") }

        val tagList         by lazy { readJsonFile("/tags/tagList.json") }
        val tagPosts        by lazy { readJsonFile("/tags/tagPosts.json") }
    }

    object Endpoints {

        private const val userId    = "0F8JIqi4zwvb77FGz6Wt"
        private const val postId    = "SFAt3mJK0qu4QOd9LgSX"
        private const val tagId     = "water"

        private const val users     = "${api.url}${api.users}"
        private const val posts     = "${api.url}${api.posts}"
        private const val tags      = "${api.url}${api.tags}"

        const val usersGetList      = "$users?limit=10"
        const val usersGetDetail    = "$users/$userId"
        const val usersGetPosts     = "$users/$userId/${api.posts}/"

        const val postsGetList      = "$posts?limit=10"
        const val postsGetComments  = "$posts/$postId/${api.comments}?limit=10"

        const val tagsGetList       = "$tags?limit=10"
        const val tagsGetPosts      = "$tags/$tagId/${api.posts}?limit=10"
    }

    fun build() = HttpClient(MockEngine) {

        engine {
            addHandler { request ->

                when (request.url.toString()) {

                    Endpoints.usersGetList      -> respond(content = MockData.userList)
                    Endpoints.usersGetDetail    -> respond(content = MockData.userDetail)
                    Endpoints.usersGetPosts     -> respond(content = MockData.userPosts)

                    Endpoints.postsGetList      -> respond(content = MockData.postList)
                    Endpoints.postsGetComments  -> respond(content = MockData.postComments)

                    Endpoints.tagsGetList       -> respond(content = MockData.tagList)
                    Endpoints.tagsGetPosts      -> respond(content = MockData.tagPosts)

                    else -> {
                        val fullUrl = request.url.toString()
                        respond("Not Found $fullUrl ${request.url.encodedPath}", HttpStatusCode.NotFound)
                    }
                }
            }
        }
        expectSuccess = false
    }

    private fun readJsonFile(fileName: String): String {

        val stream = javaClass.getResourceAsStream(fileName)
        val string = stream.bufferedReader().use { it.readText() }
        return string
    }
}