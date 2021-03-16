package dev.eduayuso.cleansamples.mvpapp.features.users

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.bindAvatarUrl
import dev.eduayuso.cleansamples.mvpapp.components.bindDate
import dev.eduayuso.cleansamples.mvpapp.components.bindImageUrl
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanActivity
import dev.eduayuso.cleansamples.mvpapp.features.posts.OnPostClickListener
import dev.eduayuso.cleansamples.mvpapp.features.posts.PostDetailActivity
import dev.eduayuso.cleansamples.mvpapp.features.posts.PostMiniListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.IUserDetailEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.users.UserDetailPresenter
import org.koin.java.KoinJavaComponent.inject

class UserDetailActivity:

        CleanActivity<IUserDetailEvents>(),
        IUserDetailEvents,
        OnPostClickListener {

    override val presenter by inject(UserDetailPresenter::class.java)
    override val layoutResourceId = R.layout.activity_user_detail

    private val progressBar by lazy { findViewById<ProgressBar>(R.id.progressBar) }
    private val userPostsRecyclerView by lazy { findViewById<RecyclerView>(R.id.userPostsRecyclerView) }
    private var userPostsRecyclerAdapter: PostMiniListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.configRecyclerView()

        if (intent.extras != null) {
            intent.extras?.getString(DataConstants.ViewArguments.userId)?.let {
                userId ->
                this.presenter.fetchUserDetail(userId)
                this.presenter.fetchUserPosts(userId)
            }
        }
    }

    private fun configRecyclerView() {

        userPostsRecyclerView?.let {
            it.layoutManager = GridLayoutManager(this, 1)
            it.setHasFixedSize(true)
            userPostsRecyclerAdapter = PostMiniListRecyclerAdapter(this)
            it.adapter = userPostsRecyclerAdapter
        }
    }

    override fun showLoading() {

        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar?.visibility = View.GONE
    }

    override fun onUserFetched(user: UserEntity) {

        supportActionBar?.title = "${user.firstName} ${user.lastName}"

        findViewById<ImageView>(R.id.userImageView)?.apply {
            bindImageUrl(user?.picture)
        }

        findViewById<TextView>(R.id.emailTextView)?.apply {
            text = "${user.email}"
        }

        findViewById<TextView>(R.id.addressTextView)?.apply {
            text = "${user.location}"
        }

        findViewById<TextView>(R.id.dateTextView)?.apply {
            bindDate("${user.dateOfBirth}")
        }
    }

    override fun onError(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onPostsFetched(posts: List<PostEntity>) {

        progressBar?.visibility = View.GONE
        userPostsRecyclerView?.visibility = View.VISIBLE
        userPostsRecyclerAdapter?.addItems(posts)
    }

    override fun onPostClick(id: String) {

        val intent = Intent(this, PostDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.postId, id)
        }
        startActivity(intent)
    }
}