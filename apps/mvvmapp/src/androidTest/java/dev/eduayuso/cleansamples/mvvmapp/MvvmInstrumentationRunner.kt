package dev.eduayuso.cleansamples.mvvmapp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * Custom Instrumentation Test runner.
 * Helps to configure environment with new App instance.
 */
class MvvmInstrumentationRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader,
                                className: String,
                                context: Context): Application {

        return super.newApplication(cl,
            TestMvvmApp::class.java.name,
            context)
    }
}