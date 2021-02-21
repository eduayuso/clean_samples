package dev.eduayuso.cleansamples.mvvmapp.features.users

import UserListRecyclerAdapter
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import dev.eduayuso.cleansamples.mvvmapp.R
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvvmapp.databinding.FragmentUserListBinding
import dev.eduayuso.cleansamples.shared.presentation.features.users.UserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment: CleanFragment<FragmentUserListBinding>() {

    override val viewModel: UserListViewModel by viewModel()
    override val layoutResourceId = R.layout.fragment_user_list

    override fun onResume() {

        super.onResume()
        this.viewModel.fetchUsers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.userListRecyclerView.adapter =  UserListRecyclerAdapter()
        val gridLayoutManager = GridLayoutManager(activity, 1)
        binding.userListRecyclerView.layoutManager = gridLayoutManager
        binding.userListRecyclerView.setHasFixedSize(true)
    }
}