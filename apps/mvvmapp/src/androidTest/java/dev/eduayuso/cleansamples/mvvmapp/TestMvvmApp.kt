package dev.eduayuso.cleansamples.mvvmapp

import org.koin.core.module.Module

/**
 * Helps to configure required dependencies for Instru Tests.
 * Method provideDependency can be overrided and new dependencies can be supplied.
 */
class TestMvvmApp: MvvmApp() {

    override fun provideDependency() = listOf<Module>()
}