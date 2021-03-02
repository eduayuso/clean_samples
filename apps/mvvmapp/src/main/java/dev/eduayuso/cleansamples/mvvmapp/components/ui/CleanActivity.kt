package dev.eduayuso.cleansamples.mvvmapp.components.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dev.eduayuso.cleansamples.mvvmapp.BR
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel

abstract class CleanActivity<BindingClass : ViewDataBinding>: AppCompatActivity() {

    protected lateinit var binding: BindingClass
    abstract val viewModel: CleanViewModel
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return true
    }
}