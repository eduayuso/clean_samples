package dev.eduayuso.cleansamples.shared.impl.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class IDepsInjection {

    fun config(app: Application) {

        startKoin {
            androidContext(app)
            modules(moduleList)
        }
    }

    fun config() {
        startKoin {
            modules(moduleList)
        }
    }

    private val moduleList by lazy {
        listOf(
            this.remoteApiClient,
            this.repositoryModule,
            this.servicesModule,
            this.dataModule,
            this.interactorsModule,
            this.viewModelModule
        )
    }

    abstract val viewModelModule: Module
    abstract val interactorsModule: Module
    abstract val servicesModule: Module
    abstract val repositoryModule: Module
    abstract val remoteApiClient: Module
    abstract val dataModule: Module
}