package dev.eduayuso.cleansamples.mvvmapp

import dev.eduayuso.cleansamples.shared.impl.DepsInjection

class TestMvvmApp: MvvmApp() {

    open override fun configDI() {

        DepsInjection.configTest(this@TestMvvmApp)
    }
}