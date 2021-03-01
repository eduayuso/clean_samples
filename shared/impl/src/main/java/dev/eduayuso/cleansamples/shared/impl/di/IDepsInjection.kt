package dev.eduayuso.cleansamples.shared.impl.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class IDepsInjection {

    fun config(app: Application, presenterModule: Module) {

        startKoin {
            androidContext(app)
            modules(moduleList.apply { add(presenterModule) })
        }
    }

    fun config() {
        startKoin {
            modules(moduleList)
        }
    }

    private val moduleList by lazy {
        mutableListOf(
            this.remoteApiClient,
            this.repositoryModule,
            this.servicesModule,
            this.dataModule,
            this.interactorsModule
        )
    }

    abstract val interactorsModule: Module
    abstract val servicesModule: Module
    abstract val repositoryModule: Module
    abstract val remoteApiClient: Module
    abstract val dataModule: Module
}