package dev.eduayuso.cleansamples.mvpapp.features.users

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvpapp.features.posts.PostDetailActivity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.IUserListEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.UserListPresenter
import org.koin.java.KoinJavaComponent.inject

class UserListFragment:

        CleanFragment<IUserListEvents>(),
        IUserListEvents,
        OnUserClickListener {

    override val presenter by inject(UserListPresenter::class.java)
    override val layoutResourceId = R.layout.fragment_user_list

    private val progressBar by lazy { view?.findViewById<ProgressBar>(R.id.userListProgressBar) }
    private val recyclerView by lazy { view?.findViewById<RecyclerView>(R.id.userListRecyclerView) }
    private var recyclerAdapter: UserListRecyclerAdapter? = null

    override fun onResume() {

        super.onResume()
        this.presenter.fetchUsers()
    }

    override fun showLoading() {

        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar?.visibility = View.GONE
    }

    override fun onUserListFetched(users: List<UserEntity>) {

        recyclerAdapter?.addItems(users)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        recyclerView?.let {
            it.layoutManager = GridLayoutManager(activity, 1)
            it.setHasFixedSize(true)
            recyclerAdapter = UserListRecyclerAdapter(this)
            it.adapter = recyclerAdapter
        }
    }

    override fun onUserClick(id: String) {

        val intent = Intent(context, UserDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.userId, id)
        }
        startActivity(intent)
    }
}