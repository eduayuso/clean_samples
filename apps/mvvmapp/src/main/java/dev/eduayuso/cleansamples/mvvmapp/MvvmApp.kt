package dev.eduayuso.cleansamples.mvvmapp

import android.app.Application
import dev.eduayuso.cleansamples.shared.impl.di.DepsInjection
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.auth.AuthViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.feed.PostListViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.home.HomeViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users.UserDetailViewModel
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

open class MvvmApp: Application() {

    override fun onCreate() {

        super.onCreate()
        this.configDI()

        Thread.setDefaultUncaughtExceptionHandler { _: Thread?, ex: Throwable ->
            ex.printStackTrace()
            System.exit(0)
        }
    }

    val viewModelModule = module {

        viewModel { AuthViewModel() }
        viewModel { HomeViewModel() }
        viewModel { UserListViewModel() }
        viewModel { UserDetailViewModel() }
        viewModel { PostListViewModel() }
    }

    protected open fun configDI() {

        DepsInjection.config(this@MvvmApp, viewModelModule)
    }
}