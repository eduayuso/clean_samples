plugins {
    id(Dependencies.Plugins.androidApplication)
    id(Dependencies.Plugins.kotlinAndroid)
    id("kotlin-kapt")
}

android {

    compileSdkVersion(Versions.Android.compileSdk)
    buildToolsVersion(Versions.Android.buildTools)

    defaultConfig {

        applicationId = Apps.MvvmApp.id
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

    buildFeatures {
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    listOf(
        Dependencies.Libs.kotlinStdLib,
        Dependencies.Libs.androidCoreKtx,
        Dependencies.Libs.koinViewModel
    ).forEach {
        implementation("$it")
    }

    Dependencies.Libs.androidUi.forEach {
        implementation("$it")
    }

    Dependencies.Libs.unitTests.forEach {
        testImplementation("$it")
    }

    Dependencies.Libs.instTests.forEach {
        androidTestImplementation("$it")
    }

    // Android apps can only access to presentation layer and DI module
    implementation(project("${Dependencies.Modules.presentation}"))
    implementation(project("${Dependencies.Modules.impl}"))
    implementation(project("${Dependencies.Modules.domain}"))
}