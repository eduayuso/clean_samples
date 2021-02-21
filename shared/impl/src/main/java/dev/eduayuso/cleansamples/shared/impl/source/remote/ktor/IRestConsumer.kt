package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor

import io.ktor.client.HttpClient
import kotlinx.serialization.StringFormat

/**
 * @property baseUrl: API base url
 * @property resourcePath: API resource to consume
 * @property httpClient: Ktor HTTP client
 * @property json: JSON format
 */
interface IRestConsumer {

    val baseUrl: String
    val resourcePath: String
    val httpClient: HttpClient
    val httpHeaders: Map<String, String>
    val json: StringFormat
}