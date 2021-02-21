package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl

import dev.eduayuso.cleansamples.shared.impl.DataConstants
import io.ktor.client.*
import kotlinx.serialization.json.Json

class CustomApiClient(

    override var baseUrl: String

) : ApiClient() {

    override val json =
        Json {
            encodeDefaults = false
            isLenient = true
            ignoreUnknownKeys = true
            useArrayPolymorphism = true
        }

    override val httpClient =

        HttpClient {

            /*install(ExceptionFeature) {
                exceptionFactory = HttpExceptionFactory(
                    defaultParser = ErrorExceptionParser(json),
                    customParsers = mapOf(
                        HttpStatusCode.UnprocessableEntity.value to ValidationExceptionParser(
                            json
                        )
                    )
                )
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }*/
            // disable standard BadResponseStatus - exceptionfactory do it for us
            expectSuccess = false
        }

    override fun getHeaders() = mapOf(

        DataConstants.Http.Headers.appId to DataConstants.Apis.DummyApi.appId
    )
}