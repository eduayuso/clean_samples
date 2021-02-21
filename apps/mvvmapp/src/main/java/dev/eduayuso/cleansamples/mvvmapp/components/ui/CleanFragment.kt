package dev.eduayuso.cleansamples.mvvmapp.components.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dev.eduayuso.cleansamples.mvvmapp.BR
import dev.eduayuso.cleansamples.shared.presentation.CleanViewModel

abstract class CleanFragment<BindingClass : ViewDataBinding>: Fragment() {

    protected lateinit var binding: BindingClass
    abstract val viewModel: CleanViewModel
    abstract val layoutResourceId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, layoutResourceId, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}