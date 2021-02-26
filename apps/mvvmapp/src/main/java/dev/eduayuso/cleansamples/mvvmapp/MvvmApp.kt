package dev.eduayuso.cleansamples.mvvmapp

import android.app.Application
import dev.eduayuso.cleansamples.shared.impl.di.DepsInjection

open class MvvmApp: Application() {

    override fun onCreate() {

        super.onCreate()
        this.configDI()

        Thread.setDefaultUncaughtExceptionHandler { thread: Thread?, ex: Throwable ->
            ex.printStackTrace()
            System.exit(0)
        }
    }

    protected open fun configDI() {

        DepsInjection.config(this@MvvmApp)
    }
}