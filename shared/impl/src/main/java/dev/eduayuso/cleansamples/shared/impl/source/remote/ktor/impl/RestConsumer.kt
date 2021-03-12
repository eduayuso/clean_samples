package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl

import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IHttpRequest
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IRestConsumer
import io.ktor.client.request.*
import io.ktor.client.utils.EmptyContent
import io.ktor.content.*
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.takeFrom
import kotlinx.serialization.KSerializer

class RestConsumer(
    api: ApiClient,
    resourcePath: String

): IRestConsumer {

    override val baseUrl = api.baseUrl
    override val resourcePath = resourcePath
    override val httpClient = api.httpClient
    override val httpHeaders = api.getHeaders()
    override val json = api.json

    fun get(): IHttpRequest {

        return this.buildRequest(HttpMethod.Get, this.resourcePath, EmptyContent)
    }

    fun get(id:Int): IHttpRequest {

        return this.buildRequest(HttpMethod.Get, "${this.resourcePath}/$id", EmptyContent)
    }

    fun <T> post(body:T, serializable: KSerializer<T>): IHttpRequest {

        val requestBody = this.buildRequestBody(body, serializable)
        return this.buildRequest(HttpMethod.Post, this.resourcePath, requestBody)
    }

    fun put(): IHttpRequest {

        return this.buildRequest(HttpMethod.Put, resourcePath, EmptyContent)
    }

    fun <T> put(id: Int, body: T, serializable: KSerializer<T>): IHttpRequest {

        val requestBody = this.buildRequestBody(body, serializable)
        return this.buildRequest(HttpMethod.Put, "${this.resourcePath}/$id", requestBody)
    }

    fun <T> put(body: T, serializable: KSerializer<T>): IHttpRequest {

        val requestBody = this.buildRequestBody(body, serializable)
        return this.buildRequest(HttpMethod.Put, resourcePath, requestBody)
    }

    fun <T> patch(id: Int, body: T, serializable: KSerializer<T>): IHttpRequest {

        val requestBody = this.buildRequestBody(body, serializable)
        return this.buildRequest(HttpMethod.Patch, "${this.resourcePath}/$id", requestBody)
    }

    fun <T> delete(body: T, serializable: KSerializer<T>): IHttpRequest {

        val requestBody = this.buildRequestBody(body, serializable)
        return this.buildRequest(HttpMethod.Delete, this.resourcePath, requestBody)
    }

    fun delete(id:Int): IHttpRequest {

        return this.buildRequest(HttpMethod.Delete, "${this.resourcePath}/$id", EmptyContent)
    }

    private fun <T> buildRequestBody(body: T, serializable: KSerializer<T>): TextContent =

        TextContent(
            json.encodeToString(serializable, body),
            ContentType.Application.Json.withoutParameters()
        )

    private fun buildRequest(method:HttpMethod, path:String, body: Any): IHttpRequest {

        val builder = HttpRequestBuilder()
        builder.method = method
        builder.body = body
        builder.url {
            takeFrom(baseUrl)
            encodedPath += path
        }
        with(builder.headers) {
            httpHeaders.map {
                append(it.key, it.value)
            }
        }

        return HttpRequest(
            this.httpClient,
            builder,
            this.json
        )
    }
}