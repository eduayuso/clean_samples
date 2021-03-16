package dev.eduayuso.cleansamples.mvpapp.components.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

abstract class CleanActivity<E: IViewEvents>: AppCompatActivity(), IViewEvents {

    abstract val presenter: CleanPresenter<E>
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.presenter.listener = this as E?
        this.setContentView(layoutResourceId)
    }

    override fun onDestroy() {

        super.onDestroy()
        this.presenter.listener = null
    }
}