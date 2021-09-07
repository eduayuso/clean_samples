object Dependencies {

    object Plugins {

        const val androidApplication    = "com.android.application"
        const val androidLibrary        = "com.android.library"
        const val kotlinAndroid         = "kotlin-android"
    }

    private const val shared            = "shared"
    private const val presentation      = "$shared:presentation"
    
    object Modules {

        const val domain                = ":$shared:domain"
        const val data                  = ":$shared:data"
        const val impl                  = ":$shared:impl"

        object Presentation {

            const val mvvm              = ":$presentation:mvvm"
            const val mvp               = ":$presentation:mvp"
            const val mvi               = ":$presentation:mvi"
        }
    }
    
    object Libs {

        const val kotlinStdLib          = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val kotlinSerialization   = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Libs.serialization}"
        const val androidCoreKtx        = "androidx.core:core-ktx:1.3.2"
        const val coroutinesAndroid     = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Libs.coroutines}"
        const val coroutinesCore        = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Libs.coroutines}"
        const val koin                  = "org.koin:koin-android:${Versions.Libs.koin}"
        const val koinViewModel         = "org.koin:koin-androidx-viewmodel:${Versions.Libs.koin}"

        val lifeCycle = listOf(
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Libs.ktx}",
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Libs.ktx}",
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Libs.ktx}"
        )

        val ktorClient = listOf(
            "io.ktor:ktor-client-android:${Versions.Libs.ktor}",
            "io.ktor:ktor-client-mock-jvm:${Versions.Libs.ktor}",
            "io.ktor:ktor-client-logging-jvm:${Versions.Libs.ktor}"
        )

        val androidUi = listOf(
            "androidx.appcompat:appcompat:1.2.0",
            "androidx.constraintlayout:constraintlayout:2.0.4",
            "com.google.android:flexbox:2.0.1",
            "androidx.navigation:navigation-fragment:2.3.2",
            "androidx.navigation:navigation-ui:2.3.2",
            "androidx.navigation:navigation-fragment-ktx:2.3.2",
            "androidx.navigation:navigation-ui-ktx:2.3.2",
            "androidx.fragment:fragment-testing:1.2.5",
            "com.squareup.picasso:picasso:2.8",
            "jp.wasabeef:picasso-transformations:2.2.1"
        )
        
        val androidCompose = listOf(
            "androidx.appcompat:appcompat:1.2.0",
            "com.google.android.material:material:1.3.0",
            "androidx.compose.material:material:${Versions.Android.compose}",
            "androidx.compose.ui:ui:${Versions.Android.compose}",
            "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1",
            "androidx.activity:activity-compose:${Versions.Android.compose}",
            "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07",
            "androidx.compose.ui:ui-tooling:${Versions.Android.compose}",
            "androidx.navigation:navigation-compose:2.4.0-alpha05"
        )

        val tests = listOf(
            "junit:junit:4.+",
            "org.koin:koin-test:${Versions.Libs.koin}",
            "androidx.test.ext:junit:${Versions.Libs.junitXExt}",
            "android.arch.core:core-testing:${Versions.Libs.androidArchCoreT}",
            "com.squareup.okhttp3:mockwebserver:${Versions.Libs.mockwebserver}",
            "org.koin:koin-test:${Versions.Libs.koin}",
            "io.mockk:mockk:${Versions.Libs.mockkVersion}"
        )
        
        // Instrumentation tests (Android components required)
        val instTests = listOf(
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Libs.coroutines}",
            "androidx.test.ext:junit:1.1.2",
            "androidx.test.espresso:espresso-core:3.3.0",
            "androidx.test.ext:junit:${Versions.Libs.junitXExt}",
            "androidx.test:rules:${Versions.Libs.testxRules}",
            "android.arch.core:core-testing:${Versions.Libs.androidArchCoreT}",
            "com.squareup.okhttp3:mockwebserver:${Versions.Libs.mockwebserver}",
            "org.koin:koin-test:${Versions.Libs.koin}",
            "androidx.test.espresso:espresso-contrib:${Versions.Libs.espressoContrib}"
        )
    }
}