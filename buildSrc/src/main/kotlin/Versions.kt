object Versions {

    /**
     * Kotlin and Gradle versions
     */
    const val kotlin                = "1.4.30"
    const val gradle                = "4.1.2"

    /**
     * Android SDK and tools versions
     */
    object Android {

        const val compileSdk        = 30
        const val targetSdk         = 30
        const val minSdk            = 21
        const val buildTools        = "30.0.2"
    }

    /**
     * Libraries versions
     */
    object Libs {

        const val material          = "1.2.1"
        const val compose           = "1.0.0-alpha10"
        const val koin              = "2.2.2"
        const val okhttp            = "4.7.2"
        const val coroutines        = "1.4.2"
        const val ktx               = "2.2.0"
    }
    
    object Testing {

        const val mockwebserver     = "4.1.0"
        const val junitXExt         = "1.1.2"
        const val testxRules        = "1.3.0"
        const val androidArchCoreT  = "1.1.1"
        const val mockkVersion      = "1.9.3"
        const val espressoContrib   = "3.3.0"
    }
}