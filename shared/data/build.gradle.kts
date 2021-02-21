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

    // Data layer only depends on domain layer
    implementation(project("${Dependencies.Modules.domain}"))
}/*