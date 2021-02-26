package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

object HttpMockApiClient {

    fun build() = HttpClient(MockEngine) {

        engine {
            addHandler { request ->
                when (request.url.fullPath) {
                    "/" -> respond(
                            ByteReadChannel(byteArrayOf(1, 2, 3)),
                            headers = headersOf("X-MyHeader", "MyValue")
                    )
                    else -> respond("Not Found ${request.url.encodedPath}", HttpStatusCode.NotFound)
                }
            }
        }
        expectSuccess = false
    }
}