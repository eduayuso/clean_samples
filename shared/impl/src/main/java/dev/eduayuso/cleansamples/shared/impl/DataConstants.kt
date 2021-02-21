package dev.eduayuso.cleansamples.shared.impl

object DataConstants {

    object Apis {

        /**
         * Fake API without authorization
         */
        object DummyApi {

            const val url = "https://dummyapi.io/data/api/"
            const val mockUrl = "http://127.0.0.1:8080"
            const val appId = "602ecc9861dfca63e9c14e16" // this should be in a environment var, and get it from Gradle through properties
            const val users = "user"
            const val posts = "post"
            const val tags = "tag"
        }
    }

    object Http {

        object Headers {

            const val authorization = "Authorization"
            const val appId = "app-id"
        }
    }
}