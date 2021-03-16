package dev.eduayuso.cleansamples.mvvmapp.features.posts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanActivity
import dev.eduayuso.cleansamples.mvvmapp.databinding.ActivityPostDetailBinding
import dev.eduayuso.cleansamples.mvvmapp.features.tags.OnTagClickListener
import dev.eduayuso.cleansamples.mvvmapp.features.tags.TagDetailActivity
import dev.eduayuso.cleansamples.mvvmapp.features.tags.TagListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.features.tags.TagMiniListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.posts.PostDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailActivity: CleanActivity<ActivityPostDetailBinding>(), OnTagClickListener {

    override val viewModel: PostDetailViewModel by viewModel()
    override val layoutResourceId = R.layout.activity_post_detail

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.setEventsObservers()
        this.configRecyclerView()

        if (intent.extras != null) {
            intent.extras?.getString(DataConstants.ViewArguments.postId)?.let { postId ->
                this.viewModel.getPost(postId)
                this.viewModel.fetchPostComments(postId)
            }
        }
    }

    private fun configRecyclerView() {

        /**
         * Tag list recycler
         */
        binding.tagsRecyclerView.adapter = TagMiniListRecyclerAdapter(this)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        layoutManager.alignItems = AlignItems.CENTER
        binding.tagsRecyclerView.layoutManager = layoutManager

        /**
         * Comment list recycler
         */
        binding.commentsRecyclerView.adapter = CommentListRecyclerAdapter()
        val gridLayoutManager = GridLayoutManager(this, 1)
        binding.commentsRecyclerView.layoutManager = gridLayoutManager
        binding.commentsRecyclerView.setHasFixedSize(true)
    }

    private fun setEventsObservers() {

        this.viewModel.errorEvent.observe(this, { event ->
            event?.getContent()?.let { errorMessage ->
                Toast.makeText(
                        this,
                        errorMessage,
                        Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    override fun onTagClick(id: String) {

        val intent = Intent(this, TagDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.tagId, id)
        }
        startActivity(intent)
    }
}