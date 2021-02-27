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

    /**
     * If you want you use MVP or other presentation model not bound to
     * Android Arquitecture Components, you could remove some of the next dependencies
     */
    listOf(
        Dependencies.Libs.kotlinStdLib,
        Dependencies.Libs.coroutinesCore,
        Dependencies.Libs.coroutinesAndroid,
        Dependencies.Libs.koin
    ).forEach {
        implementation("$it")
    }

    Dependencies.Libs.lifeCycle.forEach {
        implementation("$it")
    }

    implementation(project("${Dependencies.Modules.data}"))
    implementation(project("${Dependencies.Modules.domain}"))
}/*