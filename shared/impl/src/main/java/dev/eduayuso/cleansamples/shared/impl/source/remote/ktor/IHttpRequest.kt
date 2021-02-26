package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.StringFormat

/**
 * @property api: RESTful API client
 * @property resourcePath: API resource to consume
 * @property httpClient: Ktor HTTP client
 * @property json: JSON format
 */
interface IHttpRequest {

    val httpClient: HttpClient
    val request: HttpRequestBuilder
    val json: StringFormat

    fun with(params:String): IHttpRequest

    suspend fun <T> response(serializer: KSerializer<T>?): T?

    suspend fun response(): String?
}