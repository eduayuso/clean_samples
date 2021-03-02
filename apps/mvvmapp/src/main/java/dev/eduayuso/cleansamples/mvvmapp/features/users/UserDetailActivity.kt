package dev.eduayuso.cleansamples.mvvmapp.features.users

import PostMiniListRecyclerAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanActivity
import dev.eduayuso.cleansamples.mvvmapp.databinding.ActivityUserDetailBinding
import dev.eduayuso.cleansamples.mvvmapp.features.posts.OnPostClickListener
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users.UserDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailActivity: CleanActivity<ActivityUserDetailBinding>(), OnPostClickListener {

    override val viewModel: UserDetailViewModel by viewModel()
    override val layoutResourceId = R.layout.activity_user_detail

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.setEventsObservers()
        this.configRecyclerView()

        if (intent.extras != null) {
            intent.extras?.getString(DataConstants.ViewArguments.userId)?.let {
                userId ->
                this.viewModel.fetchUserDetail(userId)
                this.viewModel.fetchUserPosts(userId)
            }/* ?: run {
                Toast.makeText(this, R.string.error_fetching_user_details, Toast.LENGTH_LONG).show()
            }*/
        }
    }

    private fun configRecyclerView() {

        binding.userPostsRecyclerView.adapter =  PostMiniListRecyclerAdapter(this)
        val gridLayoutManager = GridLayoutManager(this, 1)
        binding.userPostsRecyclerView.layoutManager = gridLayoutManager
        binding.userPostsRecyclerView.setHasFixedSize(true)
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

        this.viewModel.viewTitleEvent.observe(this, { event ->
            event?.getContent()?.let {
                userName -> supportActionBar?.title = userName
            }
        })
    }

    override fun onPostClick(id: String) {


    }
}