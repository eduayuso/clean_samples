package dev.eduayuso.cleansamples.shared.impl

object DataConstants {

    object Apis {

        /**
         * Fake API with app id authorization
         */
        object DummyApi {

            const val url = "https://dummyapi.io/data/v1/"
            const val appId = "6116448b7a91f52f4b01c809" // this should be in a environment var, and get it from Gradle through properties
            const val users = "user"
            const val posts = "post"
            const val tags = "tag"
            const val comments = "comment"
        }
    }

    object Http {

        object Headers {

            const val authorization = "Authorization"
            const val appId = "app-id"
        }
    }

    object ViewArguments {

        const val userId = "userId"
        const val postId = "postId"
        const val tagId = "tagId"
    }
}
