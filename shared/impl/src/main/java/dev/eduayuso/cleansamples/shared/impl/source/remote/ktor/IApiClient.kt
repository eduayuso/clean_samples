package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor

import io.ktor.client.*
import kotlinx.serialization.json.Json

interface IApiClient {

    val json: Json
    val baseUrl: String
    val httpClient: HttpClient
    fun getHeaders(): Map<String, String>
}