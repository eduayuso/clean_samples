package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl

import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IHttpRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.ReceivePipelineException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import kotlinx.serialization.KSerializer
import kotlinx.serialization.StringFormat

class HttpRequest(

    override val httpClient: HttpClient,
    override val request: HttpRequestBuilder,
    override val json: StringFormat

): IHttpRequest {

    private val PARAM_DELIMITER = "="

    override fun with(params:String): IHttpRequest {

        val splitted = params.split(PARAM_DELIMITER)
        this.request.url.parameters.append(splitted[0],splitted[1])
        return this
    }

    override suspend fun <T> response(serializer: KSerializer<T>?): T? {

        try {
            val result: String = httpClient.request(this.request)
            return if (serializer == null) null
            else this.json.decodeFromString(serializer, result)
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }

    override suspend fun response(): String? {

        try {
            return httpClient.request<String>(request)
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }
}