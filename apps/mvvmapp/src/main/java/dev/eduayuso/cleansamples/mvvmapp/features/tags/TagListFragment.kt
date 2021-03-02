package dev.eduayuso.cleansamples.mvvmapp.features.tags

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvvmapp.databinding.FragmentTagListBinding
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.tags.TagListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TagListFragment: CleanFragment<FragmentTagListBinding>(), OnTagClickListener {

    override val viewModel: TagListViewModel by viewModel()
    override val layoutResourceId = R.layout.fragment_tag_list

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.setEventsObservers()
    }

    private fun setEventsObservers() {

        this.viewModel.errorEvent.observe(this, { event ->
            event?.getContent()?.let { errorMessage ->
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onResume() {

        super.onResume()
        this.viewModel.fetchTags()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.tagListRecyclerView.adapter = TagListRecyclerAdapter(this)
        val gridLayoutManager = GridLayoutManager(activity, 1)
        binding.tagListRecyclerView.layoutManager = gridLayoutManager
        binding.tagListRecyclerView.setHasFixedSize(true)
    }

    override fun onTagClick(id: String) {

        /*val intent = Intent(context, UserDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.userId, id)
        }
        startActivity(intent)*/
    }
}