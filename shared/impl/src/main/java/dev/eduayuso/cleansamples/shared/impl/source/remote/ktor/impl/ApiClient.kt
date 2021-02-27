package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl

import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IApiClient
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IRestConsumer
import io.ktor.client.*
import kotlinx.serialization.json.Json

class ApiClient(

    override var baseUrl: String,
    override val httpClient: HttpClient

): IApiClient {

    override val json =
        Json {
            encodeDefaults = false
            isLenient = true
            ignoreUnknownKeys = true
            useArrayPolymorphism = true
        }

    override fun getHeaders() = mapOf(

        DataConstants.Http.Headers.appId to DataConstants.Apis.DummyApi.appId
    )

    fun consume(url:String): RestConsumer {
        return RestConsumer(this, url)
    }
}

