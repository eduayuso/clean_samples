package dev.eduayuso.cleansamples.mvpapp

import android.app.Application
import dev.eduayuso.cleansamples.mvpapp.features.tags.TagDetailActivity
import dev.eduayuso.cleansamples.shared.impl.di.DepsInjection
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts.PostDetailPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts.PostListPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags.TagDetailPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags.TagListPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.UserDetailPresenter
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

        single { PostListPresenter() }
        single { PostDetailPresenter() }

        single { UserListPresenter() }
        single { UserDetailPresenter() }

        single { TagListPresenter() }
        single { TagDetailPresenter() }
    }

    protected open fun configDI() {

        DepsInjection.config(this@MvpApp, presentersModule)
    }
}