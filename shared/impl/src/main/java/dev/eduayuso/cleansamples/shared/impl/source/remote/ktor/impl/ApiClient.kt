package dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl

import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IApiClient
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.IRestConsumer

abstract class ApiClient: IApiClient {

    fun consume(url:String): RestConsumer {
        return RestConsumer(this, url)
    }
}

