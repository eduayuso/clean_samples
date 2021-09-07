plugins {
    id(Dependencies.Plugins.androidLibrary)
    id(Dependencies.Plugins.kotlinAndroid)
}

android {
    compileSdk = Versions.Android.compileSdk
    buildToolsVersion = Versions.Android.buildTools

    defaultConfig {

        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.targetSdk

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
        jvmTarget = Versions.java
    }
}

dependencies {

    // Data layer only depends on domain layer
    implementation(project("${Dependencies.Modules.domain}"))
}/*