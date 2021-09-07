plugins {
    id(Dependencies.Plugins.androidApplication)
    id(Dependencies.Plugins.kotlinAndroid)
    id("kotlin-kapt")
}

val app = Apps.ComposeMvvmApp

android {

    compileSdk = Versions.Android.compileSdk
    buildToolsVersion  = Versions.Android.buildTools

    defaultConfig {

        applicationId = app.id
        versionName = app.versionName
        versionCode = app.versionCode

        minSdk = Versions.Android.minSdk
        targetSdk =Versions.Android.targetSdk

        testInstrumentationRunner = app.testInstRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        dataBinding = app.useDataBinding
        compose = app.compose
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/*.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Versions.java
        useIR = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Android.compose
    }
}

dependencies {

    listOf(
        Dependencies.Libs.kotlinStdLib,
        Dependencies.Libs.androidCoreKtx,
        Dependencies.Libs.koin
    ).forEach {
        implementation("$it")
    }

    Dependencies.Libs.androidCompose.forEach {
        implementation("$it")
    }

    Dependencies.Libs.tests.forEach {
        testImplementation("$it")
    }

    Dependencies.Libs.instTests.forEach {
        androidTestImplementation("$it")
    }

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.01")

    // Android apps can only access to presentation layer and DI module
    implementation(project("${Dependencies.Modules.Presentation.mvvm}"))
    implementation(project("${Dependencies.Modules.impl}"))
    implementation(project("${Dependencies.Modules.domain}"))
}