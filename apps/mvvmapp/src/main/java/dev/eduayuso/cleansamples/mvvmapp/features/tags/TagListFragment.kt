package dev.eduayuso.cleansamples.mvvmapp.features.tags

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvvmapp.databinding.FragmentTagListBinding
import dev.eduayuso.cleansamples.shared.impl.DataConstants
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
        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        layoutManager.alignItems = AlignItems.CENTER
        binding.tagListRecyclerView.layoutManager = layoutManager
    }

    override fun onTagClick(id: String) {

        val intent = Intent(context, TagDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.tagId, id)
        }
        startActivity(intent)
    }
}