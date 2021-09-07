plugins {
    id(Dependencies.Plugins.androidLibrary)
    id(Dependencies.Plugins.kotlinAndroid)
    kotlin("plugin.serialization") version Versions.kotlin
}

android {
    compileSdk = Versions.Android.compileSdk
    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
}

dependencies {

    // 'api' instead of 'implementation' to make it accessible in projects/modules that import this module
    api(Dependencies.Libs.kotlinSerialization)
}