object Dependencies {

    object Plugins {

        const val androidApplication    = "com.android.application"
        const val androidLibrary        = "com.android.library"
        const val kotlinAndroid         = "kotlin-android"
    }

    private const val shared = "shared"
    
    object Modules {

        const val domain                = ":$shared:domain"
        const val data                  = ":$shared:data"
        const val presentation          = ":$shared:presentation"
        const val impl                  = ":$shared:impl"
    }
    
    object Libs {

        const val kotlinStdLib          = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val androidCoreKtx        = "androidx.core:core-ktx:1.3.2"
        const val coroutinesAndroid     = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Libs.coroutines}"
        const val coroutinesCore        = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Libs.coroutines}"
        const val koin                  = "org.koin:koin-android:${Versions.Libs.koin}"
        const val koinViewModel         = "org.koin:koin-androidx-viewmodel:${Versions.Libs.koin}"
        const val lifecycleViewmodel    = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Libs.ktx}"
        const val lifecycleRuntime      = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Libs.ktx}"
        const val lifecycleLivedata     = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Libs.ktx}"
        const val ktorClient            = "io.ktor:ktor-client-android:1.3.2"

        val androidUi = listOf(
            "androidx.appcompat:appcompat:1.2.0",
            "androidx.constraintlayout:constraintlayout:2.0.4",
            "androidx.navigation:navigation-fragment:2.3.2",
            "androidx.navigation:navigation-ui:2.3.2",
            "androidx.navigation:navigation-fragment-ktx:2.3.2",
            "androidx.navigation:navigation-ui-ktx:2.3.2",
            "com.squareup.picasso:picasso:2.8"
        )

        val unitTests = listOf(
            "junit:junit:4.+",
            "org.koin:koin-test:${Versions.Libs.koin}"
        )

        // Instrumentation tests (Android components required)
        val instTests = listOf(
            "androidx.test.ext:junit:1.1.2",
            "androidx.test.espresso:espresso-core:3.3.0"
        )
    }
}