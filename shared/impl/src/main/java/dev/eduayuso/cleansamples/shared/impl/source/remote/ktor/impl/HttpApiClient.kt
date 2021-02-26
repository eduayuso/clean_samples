package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl

import io.ktor.client.*
import io.ktor.client.features.logging.*

object HttpApiClient {

    fun build() = HttpClient {

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }
        // disable standard BadResponseStatus - exceptionfactory do it for us
        expectSuccess = false
    }
}