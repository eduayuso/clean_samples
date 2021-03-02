package dev.eduayuso.cleansamples.mvvmapp.features.users

import UserListRecyclerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvvmapp.databinding.FragmentUserListBinding
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users.UserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment: CleanFragment<FragmentUserListBinding>(), OnUserClickListener {

    override val viewModel: UserListViewModel by viewModel()
    override val layoutResourceId = R.layout.fragment_user_list

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
        this.viewModel.fetchUsers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.userListRecyclerView.adapter =  UserListRecyclerAdapter(this)
        val gridLayoutManager = GridLayoutManager(activity, 1)
        binding.userListRecyclerView.layoutManager = gridLayoutManager
        binding.userListRecyclerView.setHasFixedSize(true)
    }

    override fun onUserClick(id: String) {

        val intent = Intent(context, UserDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.userId, id)
        }
        startActivity(intent)
    }
}