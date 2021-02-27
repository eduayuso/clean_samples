package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor

import dev.eduayuso.cleansamples.shared.impl.DataConstants
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*

object HttpMockApiClient {

    private val api = DataConstants.Apis.DummyApi

    object MockData {

        val userList    by lazy { readJsonFile("/userList.json") }
        val userDetail  by lazy { readJsonFile("/userDetail.json") }
        val userPosts   by lazy { readJsonFile("/userPosts.json") }
    }

    const val userId            = "0F8JIqi4zwvb77FGz6Wt"

    object Endpoints {
        const val users             = "${api.url}${api.users}"
        const val usersGetList      = "$users?limit=10"
        const val usersGetDetail    = "$users/$userId"
        const val usersGetPosts     = "$users/$userId/${api.posts}/"
    }

    fun build() = HttpClient(MockEngine) {

        engine {
            addHandler { request ->

                when (request.url.toString()) {

                    Endpoints.usersGetList      -> respond(content = MockData.userList)
                    Endpoints.usersGetDetail    -> respond(content = MockData.userDetail)
                    Endpoints.usersGetPosts     -> respond(content = MockData.userPosts)

                    else -> {
                        val a = request.url.toString()
                        respond("Not Found $a ${request.url.encodedPath}", HttpStatusCode.NotFound)
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