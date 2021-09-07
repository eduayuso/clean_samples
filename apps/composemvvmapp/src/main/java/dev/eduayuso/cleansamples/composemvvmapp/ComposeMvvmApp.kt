package dev.eduayuso.cleansamples.composemvvmapp

import android.app.Application

class ComposeMvvmApp: Application() {

    override fun onCreate() {

        super.onCreate()

        Thread.setDefaultUncaughtExceptionHandler { _: Thread?, ex: Throwable ->
            ex.printStackTrace()
            System.exit(0)
        }
    }
}