package dev.eduayuso.cleansamples.mvpapp

import android.app.Application
import dev.eduayuso.cleansamples.shared.impl.di.DepsInjection
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.feed.PostListPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.UserListPresenter
import org.koin.dsl.module

open class MvpApp: Application() {

    override fun onCreate() {

        super.onCreate()
        this.configDI()

        Thread.setDefaultUncaughtExceptionHandler { _: Thread?, ex: Throwable ->
            ex.printStackTrace()
            System.exit(0)
        }
    }

    val presentersModule = module {

        single { UserListPresenter() }
        single { PostListPresenter() }
    }

    protected open fun configDI() {

        DepsInjection.config(this@MvpApp, presentersModule)
    }
}