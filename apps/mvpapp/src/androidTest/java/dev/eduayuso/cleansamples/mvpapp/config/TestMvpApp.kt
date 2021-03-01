package dev.eduayuso.cleansamples.mvpapp.config

import dev.eduayuso.cleansamples.mvpapp.MvpApp
import dev.eduayuso.cleansamples.shared.impl.di.TestsDepsInjection

class TestMvpApp: MvpApp() {

    open override fun configDI() {

        TestsDepsInjection.config(this@TestMvpApp, presentersModule)
    }
}