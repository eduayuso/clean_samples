plugins {
    id(Dependencies.Plugins.androidLibrary)
    id(Dependencies.Plugins.kotlinAndroid)
}

android {
    compileSdkVersion(Versions.Android.compileSdk)
    buildToolsVersion(Versions.Android.buildTools)

    defaultConfig {

        versionName = Apps.MvvmApp.versionName
        versionCode = Apps.MvvmApp.versionCode

        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    listOf(
        Dependencies.Libs.coroutinesCore,
        Dependencies.Libs.coroutinesAndroid,
        Dependencies.Libs.koin,
        Dependencies.Libs.koinViewModel,
        Dependencies.Libs.ktorClient
    ).forEach {
        implementation("$it")
    }

    Dependencies.Libs.tests.forEach {
        testImplementation("$it")
    }

    listOf(
        Dependencies.Modules.data,
        Dependencies.Modules.domain,
        Dependencies.Modules.presentation
    ).forEach {
        implementation(project("$it"))
    }
}