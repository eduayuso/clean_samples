package dev.eduayuso.cleansamples.mvpapp.components.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.shared.presentation.mvp.CleanPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

abstract class CleanFragment<E: IViewEvents>: Fragment(), IViewEvents {

    abstract val presenter: CleanPresenter<E>
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.presenter.listener = this as E?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(this.layoutResourceId, container, false)
    }

    override fun onDestroy() {

        super.onDestroy()
        this.presenter.listener = null
    }
}