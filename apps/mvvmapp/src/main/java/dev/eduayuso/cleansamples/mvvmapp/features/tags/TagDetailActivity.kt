package dev.eduayuso.cleansamples.mvvmapp.features.tags

import PostListRecyclerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanActivity
import dev.eduayuso.cleansamples.mvvmapp.databinding.ActivityTagDetailBinding
import dev.eduayuso.cleansamples.mvvmapp.features.posts.OnPostClickListener
import dev.eduayuso.cleansamples.mvvmapp.features.posts.PostDetailActivity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.tags.TagDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TagDetailActivity: CleanActivity<ActivityTagDetailBinding>(), OnPostClickListener {

    override val viewModel: TagDetailViewModel by viewModel()
    override val layoutResourceId = R.layout.activity_tag_detail

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding.postListRecyclerView.adapter = PostListRecyclerAdapter(this)
        val gridLayoutManager = GridLayoutManager(this, 1)
        binding.postListRecyclerView.layoutManager = gridLayoutManager
        binding.postListRecyclerView.setHasFixedSize(true)

        if (intent.extras != null) {
            intent.extras?.getString(DataConstants.ViewArguments.tagId)?.let { tag ->
                viewModel.fetchPostsByTag(tag)
                supportActionBar?.title = "Posts tagged '$tag'"
            }
        }
    }

    override fun onPostClick(id: String) {

        val intent = Intent(this, PostDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.postId, id)
        }
        startActivity(intent)
    }
}