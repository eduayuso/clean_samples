package dev.eduayuso.cleansamples.mvvmapp.config

import dev.eduayuso.cleansamples.mvvmapp.MvvmApp
import dev.eduayuso.cleansamples.shared.impl.di.TestsDepsInjection

class TestMvvmApp: MvvmApp() {

    open override fun configDI() {

        TestsDepsInjection.config(this@TestMvvmApp)
    }
}