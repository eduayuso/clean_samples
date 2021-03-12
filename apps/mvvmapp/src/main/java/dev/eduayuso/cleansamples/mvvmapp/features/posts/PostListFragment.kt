package dev.eduayuso.cleansamples.mvvmapp.features.posts

import PostListRecyclerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvvmapp.databinding.FragmentPostListBinding
import dev.eduayuso.cleansamples.mvvmapp.features.users.UserDetailActivity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.posts.PostListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostListFragment: CleanFragment<FragmentPostListBinding>(), OnPostClickListener {

    override val viewModel: PostListViewModel by viewModel()
    override val layoutResourceId = R.layout.fragment_post_list

    override fun onResume() {

        super.onResume()
        this.viewModel.fetchPosts()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.postListRecyclerView.adapter = PostListRecyclerAdapter(this)
        val gridLayoutManager = GridLayoutManager(activity, 1)
        binding.postListRecyclerView.layoutManager = gridLayoutManager
        binding.postListRecyclerView.setHasFixedSize(true)
    }

    override fun onPostClick(id: String) {

        val intent = Intent(context, PostDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.postId, id)
        }
        startActivity(intent)
    }
}